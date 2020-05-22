buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:0.9.+'
    }
}

apply plugin: 'android'

repositories {
    mavenCentral()
    maven { url "${System.env.HOME}/.m2/repository" } // mavenLocal()
}

dependencies {
    compile 'some.likely.group.name.goes.here:name-of-library:0.4.0'
}

android {
    // as normal
}