apply plugin: 'com.android.application'

android {
    compileSdkVersion 23
    buildToolsVersion "23.0.1"

    defaultConfig {
        applicationId "com.lfreytag.tidenow"
        minSdkVersion 7
        targetSdkVersion 23
        versionCode 1
        versionName "1.0"
    }

    productFlavors {
        wa {
            applicationId "com.lfreytag.tidenow.wa"
        }

        or {
            applicationId "com.lfreytag.tidenow.or"
        }

        ca {
            applicationId "com.lfreytag.tidenow.ca"
        }

        ... etc ...
    }

    buildTypes {
        ...
    }
}

dependencies {
    ...
}