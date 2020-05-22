buildscript {
    ext.kotlin_version = '1.1.3-2'
    apply from: 'dependencies.gradle'
    repositories {
        ...
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.0-alpha6'
        classpath ('com.google.firebase:firebase-plugins:1.1.0') //the firebase line
        ....
    }
}