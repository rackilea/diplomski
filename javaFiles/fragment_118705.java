android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "applicationId"
        minSdkVersion 21
        targetSdkVersion 28
        versionCode 1 ----- Here you should change your versionCode
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}