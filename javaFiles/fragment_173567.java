buildscript {
    ext.kotlin_version = '1.3.50'
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url 'https://maven.google.com' }
    }
    ...
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://maven.google.com/' }
        maven { url "https://s3.amazonaws.com/moat-sdk-builds" }
    }
}