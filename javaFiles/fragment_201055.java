apply plugin: 'com.android.application'

android {
    compileSdkVersion 23
    buildToolsVersion "23.0.3"

    defaultConfig {
        //your application id here
        applicationId "yourapp.com.demoapps"
        minSdkVersion 15
        targetSdkVersion 23
        versionCode 1
        versionName "1.0"
        multiDexEnabled true
    }
    dexOptions {

        javaMaxHeapSize "4g"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}
dependencies {
     compile fileTree(include: ['*.jar'], dir: 'libs')
     testCompile 'junit:junit:4.12'
     compile 'com.android.support:appcompat-v7:23.2.1' 
     compile 'com.android.support:design:23.2.1'
     compile 'com.android.support:support-v4:23.2.1'
     compile 'com.google.android.gms:play-services:8.4.0'
     compile 'com.google.android.gms:play-services-maps:8.4.0'
     compile 'com.parse.bolts:bolts-android:1.4.0' 
     compile 'com.parse:parse-android:1.13.0' 
     compile 'com.firebase:firebase-client-android:2.5.2'
            }