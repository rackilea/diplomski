apply plugin: 'com.android.application'

android {
    compileSdkVersion 24
    buildToolsVersion "24.0.2"
    packagingOptions {
        pickFirst 'META-INF/LICENSE.txt' // picks the JavaMail license file
    }

    defaultConfig {
        applicationId "myNam.myAPP"
        minSdkVersion 18
        targetSdkVersion 24
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

repositories {
    jcenter()
    maven {
        url "https://maven.java.net/content/groups/public/"
    }
}

dependencies {
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:24.2.1'
    compile 'com.sun.mail:android-mail:1.6.2'
    compile 'com.sun.mail:android-activation:1.6.2'
    provided files('libs/javax.mail.jar')
}