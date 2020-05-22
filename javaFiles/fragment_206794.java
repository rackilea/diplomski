buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        ... add this classpath to your buildscript dependencies
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.4'
    }
}

apply plugin: 'com.android.application'
apply plugin: 'com.neenbedankt.android-apt' << apply the plugin after the android plugin

dependencies {
    // in dependencies you call it
    apt 'com.company.myAnnotation:plugin:1.0-SNAPSHOT'
    compile 'com.company.myAnnotation:api:1.0-SNAPSHOT'