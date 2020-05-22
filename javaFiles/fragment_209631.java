buildscript {
    repositories {
        maven { url 'https://maven.fabric.io/public' }
    }

    dependencies {
        classpath 'io.fabric.tools:gradle:1.+'
    }
}
apply plugin: 'com.android.application'
apply plugin: 'io.fabric'

repositories {
    maven { url 'https://maven.fabric.io/public' }
}

android {

    compileSdkVersion 22
    buildToolsVersion "22.0.1"
    defaultConfig {
        applicationId "com.app.kljdrfqwxcqgzzimiygdcwrshoxalmfyuonetatuvj"
        minSdkVersion 15
        targetSdkVersion 22
        versionCode 30
        versionName "1.0"
        multiDexEnabled true
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    defaultConfig {
        multiDexEnabled true
        ndk {
            abiFilters "armeabi", "armeabi-v7a", "x86", "mips"
        }
    }
    lintOptions{
        disable "ResourceType"
    }

    packagingOptions {
        exclude 'META-INF/DEPENDENCIES'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/LICENSE.txt'
        exclude 'META-INF/NOTICE.txt'
    }
    dexOptions {
        incremental = true;
        javaMaxHeapSize "4g"
        preDexLibraries = false
    }

    configurations {
        all*.exclude group: 'com.android.support', module: 'support-v4'
    }

}

allprojects {
    apply plugin: 'maven'
    repositories {
        mavenCentral()
        jcenter()
        maven {
            url "${project.rootDir}/creativesdk-repo/release"
        }
    }
}


dependencies {
    //compile fileTree(include: ['*.jar'], exclude: 'android-support-v4.jar',dir: 'libs')
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile 'com.android.support:appcompat-v7:22.2.0'
    compile 'com.android.support:design:22.2.0'
    compile 'com.google.android.gms:play-services:7.+'
    compile 'com.github.bumptech.glide:glide:3.7.0'
    compile('com.adobe.creativesdk.foundation:auth:0.7.329') {
        exclude group: 'com.android.support', module: 'support-annotations'
        exclude module: 'support-v4'
    }
    compile('com.adobe.creativesdk:image:4.0.0') {
        exclude module: 'support-v4'
        exclude group: 'com.android.support', module: 'support-annotations'
    }
    compile('com.android.support:multidex:1.0.1') {
        exclude group: 'com.android.support', module: 'multidex'
    }
    //compile files('libs/commons-io-2.4.jar')
    compile files('libs/YouTubeAndroidPlayerApi.jar')
    compile files('libs/aacdecoder-android-0.8.jar')
    compile files('libs/skyepub.jar')
    compile files('libs/httpcore-4.3.jar')
    compile files('libs/anjlab-iabv3-1.0.23.jar')
    compile files('libs/quickblox-android-sdk-chat-2.1.jar')
    compile files('libs/quickblox-android-sdk-content-2.1.jar')
    compile files('libs/quickblox-android-sdk-core-2.1.jar')
    compile files('libs/quickblox-android-sdk-location-2.1.jar')
    compile files('libs/quickblox-android-sdk-messages-2.1.jar')
    compile files('libs/quickblox-android-sdk-videochat-webrtc-2.1.jar')
    //compile files('libs/android-support-v4.jar')
    compile 'com.android.support:support-v4:22.2.0'
    // compile 'com.android.support:support-annotations:22.2.0'
    //    compile ('com.android.support:support-v4:23.1.1')
    //            {
    //                force=true
    //            }
    //    compile ('com.android.support:support-annotations:23.1.1')
    //            {
    //                force=true
    //            }
    compile project(':stripe')
    compile 'com.facebook.android:facebook-android-sdk:4.8.0'
    compile project(':vitamio')
    compile project(':zxing-scan')
    compile('com.twitter.sdk.android:twitter:2.0.0@aar') {
        transitive = true;
    }
    compile project(':libraryProject_AppypiePdf')
    compile project(':linkedin-sdk')
    compile project(':CastCompanionLibrary-android')
    compile 'net.ypresto.androidtranscoder:android-transcoder:0.2.0'
    compile project(path: ':de.keyboardsurfer.android.widget.crouton')
    compile project(path: ':pull-to-refresh')
}