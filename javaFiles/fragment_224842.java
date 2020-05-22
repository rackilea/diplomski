apply plugin: 'com.android.application'

android {
    compileSdkVersion 23
    buildToolsVersion "23.0.2"

    defaultConfig {
        applicationId "com.cprakashagr.jni"
        minSdkVersion 21
        targetSdkVersion 23

        ndk {
            moduleName "ndkfoo"
        }
    }

    sourceSets.main {
        jniLibs.srcDir 'src/main/libs' //set libs as .so's location instead of jni
        jni.srcDirs = [] //disable automatic ndk-build call with auto-generated Android.mk file
    }


    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
        }
    }

}

dependencies {
    compile 'com.android.support:support-v4:23.1.1'
}