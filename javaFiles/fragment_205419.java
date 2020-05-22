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




android {

    aaptOptions.setProperty("cruncherEnabled", false)
    sourceSets {

        androidTest {
            java.srcDirs = ['src/androidTest/java']
        }
    }
    lintOptions {
        // set to true to turn off analysis progress reporting by lint
        quiet true
        // if true, stop the gradle build if errors are found
        abortOnError false
        // if true, only report errors
        ignoreWarnings true
    }
    productFlavors {
        // The actual application flavor
        production {
            minSdkVersion 15
        }
        // Test application flavor for uiautomatior tests
        myTest {
            minSdkVersion 18
        }
    }
    compileSdkVersion 23
    buildToolsVersion "23.0.2"
    defaultConfig {
        applicationId "com.greenrobot.yesorno"
        minSdkVersion 15
        targetSdkVersion 22
        multiDexEnabled = true
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
        }
    }
    packagingOptions {
        exclude 'META-INF/ASL2.0'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/maven/com.google.guava/guava/pom.properties'
        exclude 'META-INF/maven/com.google.guava/guava/pom.xml'
    }
}

repositories {
    mavenCentral()
    maven { url 'https://maven.fabric.io/public' }
}

repositories {
    maven { url "http://jzaccone.github.io/SlidingMenu-aar" }

}
repositories {
    maven { url "http://dl.bintray.com/populov/maven" }
    maven { url 'https://oss.sonatype.org/content/repositories/snapshots' }
}

def autobahn_version = '0.5.2-SNAPSHOT'

dependencies {
    compile 'com.squareup.picasso:picasso:2.5.2'
    compile 'com.android.support:multidex:1.0.1'
    compile 'com.robbypond:mopub-android-sdk:3.9.0'
    compile 'com.facebook.android:facebook-android-sdk:4.7.0'
    compile 'com.jeremyfeinstein.slidingmenu:library:1.3@aar'
    compile 'com.android.support:support-v4:23.1.1'
    compile files('libs/FlurryAgent.jar')
    //compile files('libs/autobahn-android-0.5.2-SNAPSHOT.jar')
    compile 'de.tavendo:autobahn-android:' + autobahn_version
    compile 'com.actionbarsherlock:actionbarsherlock:4.4.0@aar'
    compile project(':viewpagerindicator')
    compile files('libs/gcm.jar')
    compile 'com.jakewharton.timber:timber:3.1.0'
    compile('com.crashlytics.sdk.android:crashlytics:2.5.5@aar') {
        transitive = true;
    }
    compile 'com.squareup.okhttp3:okhttp:3.0.1'
    compile 'com.android.support:support-annotations:23.1.1'
    compile 'com.google.guava:guava:18.0'
    // Testing-only dependencies
    androidTestCompile 'com.android.support:support-annotations:23.1.1'
    androidTestCompile 'com.android.support.test:runner:0.4.1'
    androidTestCompile 'com.android.support.test:rules:0.4.1'
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2.1'
    androidTestCompile 'com.android.support.test.uiautomator:uiautomator-v18:2.0.0'
    androidTestCompile 'junit:junit:4.12'
}