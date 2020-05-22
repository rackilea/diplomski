buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        ...
        classpath 'com.vanniktech:gradle-android-junit-jacoco-plugin:0.13.0'
        ...
    }
}
...

apply plugin: 'com.vanniktech.android.junit.jacoco'