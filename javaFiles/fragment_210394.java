apply plugin: 'com.android.application'

dependencies {
    compile 'com.android.support:appcompat-v7:24.0.0'
    compile('com.google.android.gms:play-services:9.0.2')
    compile ('com.google.android.gms:play-services-analytics:9.0.2')
    compile files('libs/ksoap2-android-assembly-2.5.8-jar-with-dependencies.jar')
    compile "com.android.support:design:24.0.0"
    compile 'com.android.support:multidex:1.0.1'
    compile files('libs/mail.jar')
    compile files('libs/activation.jar')
    compile files('libs/gcm.jar')
}

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.1.2'
    }
}

android {
    compileSdkVersion 23
    buildToolsVersion "23.0.3"
    useLibrary  'org.apache.http.legacy'

    defaultConfig {

        applicationId "com.expedite.apps.vedant"
        minSdkVersion 9
        targetSdkVersion 23
        versionCode 1
        versionName "1.0"
        multiDexEnabled true
    }
    packagingOptions {
        exclude 'META-INF/NOTICE.txt' // will not include NOTICE file
        exclude 'META-INF/LICENSE.txt' // will not include LICENSE file
        exclude 'META-INF/LICENSE-FIREBASE.txt'
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    dexOptions {
        javaMaxHeapSize "4g"
    }

    sourceSets {
        main {
            manifest.srcFile 'AndroidManifest.xml'
            java.srcDirs = ['src']
            resources.srcDirs = ['src']
            aidl.srcDirs = ['src']
            renderscript.srcDirs = ['src']
            res.srcDirs = ['res']
            assets.srcDirs = ['assets']
        }

        // Move the tests to tests/java, tests/res, etc...
        instrumentTest.setRoot('tests')

        // Move the build types to build-types/<type>
        // For instance, build-types/debug/java, build-types/debug/AndroidManifest.xml, ...
        // This moves them out of them default location under src/<type>/... which would
        // conflict with src/ being used by the main source set.
        // Adding new build types or product flavors should be accompanied
        // by a similar customization.
        debug.setRoot('build-types/debug')
        release.setRoot('build-types/release')
    }
}