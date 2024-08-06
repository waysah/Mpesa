plugins {
    alias(libs.plugins.android.application)
}

val darajaConsumerKey = System.getenv("DARAJA_CONSUMER_KEY") ?: "r03OG4rRsYhAS9oXHuieJHayb7Hckpt7lYfV6d1E2edh6GjG"
val darajaConsumerSecret = System.getenv("DARAJA_CONSUMER_SECRET") ?: "nCJUbiVwFttQgcWjaA0gDyl7kvKJ4Up4MjmVDgVZJAAVGnYt1Gn6C39v4RI84LkW"

android {
    namespace = "com.example.mpesatest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mpesatest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        // Applying consumer keys to all build types using forEach
        forEach { buildType ->
            buildType.buildConfigField("String", "CONSUMER_KEY", "\"$darajaConsumerKey\"")
            buildType.buildConfigField("String", "CONSUMER_SECRET", "\"$darajaConsumerSecret\"")
        }
    }

    buildFeatures {
        // Enable custom BuildConfig fields
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "CONSUMER_KEY", "\"r03OG4rRsYhAS9oXHuieJHayb7Hckpt7lYfV6d1E2edh6GjG\"")
        buildConfigField ("String", "CONSUMER_SECRET", "\"nCJUbiVwFttQgcWjaA0gDyl7kvKJ4Up4MjmVDgVZJAAVGnYt1Gn6C39v4RI84LkW\"")
        multiDexEnabled = true
    }


    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //mpesa intergration
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("cn.pedant.sweetalert:library:1.3") {
        exclude (group = "com.android.support")
    }
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")

    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    implementation("com.google.code.gson:gson:2.8.5")

    implementation("com.squareup.okio:okio:2.1.0")
}