buildscript {
    repositories {
        jcenter()
        google()
        //or
       // maven { url 'https://maven.google.com' }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'
        classpath 'net.hockeyapp.android:HockeySDK:4.1.0'
        classpath 'com.google.gms:google-services:3.1.1' //use latest plugin version


    }
}