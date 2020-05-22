android {
    compileSdkVersion 27
    defaultConfig {
        applicationId "com.xx.xxx"
        minSdkVersion 15
        targetSdkVersion 27
        versionCode 1
        versionName "1.0"
        multiDexEnabled true //Add this
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            shrinkResources true
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}