// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        jcenter()
        maven {
            url 'https://oss.sonatype.org/content/repositories/ksoap2-android-releases/'
        }

        maven {
            url 'http://dl.bintray.com/amulyakhare/maven'
        }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.1'
        classpath 'com.jakewharton:butterknife-gradle-plugin:8.8.1'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        //google()
        maven {
            url 'https://maven.google.com'
        }
        jcenter()
        maven { url "https://jitpack.io" }

    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}