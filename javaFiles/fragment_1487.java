android {
compileSdkVersion 25
buildToolsVersion "25.0.0"
defaultConfig {
    applicationId "com.example.mike.lol10"
    minSdkVersion 16
    targetSdkVersion 25
    versionCode 1
    versionName "1.0"
    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    externalNativeBuild {
        cmake {
            cppFlags "-frtti -fexceptions"
        }
    }
}
buildTypes {
    release {
        minifyEnabled true
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
}
externalNativeBuild {
    cmake {
        path "CMakeLists.txt"
    }
}
}