android {
    compileSdkVersion 21
    buildToolsVersion "21.1.2"
    defaultConfig {
        applicationId "org.example.test"
        minSdkVersion 17
        targetSdkVersion 21
        versionCode 1
        versionName "1.0"

        **multiDexEnabled true**

    }

    ***dexOptions{
        preDexLibraries false
    }***

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    productFlavors {
    }
}