apply plugin: 'android'

repositories {
    maven {
       url "http://mente.github.io/facebook-api-android-aar"
    }
}

dependencies {
   compile fileTree(dir: 'libs', include: '*.jar') // this includes all .jar libs
   compile 'com.facebook:facebook-android-sdk:3.5.2@aar' // this downloads facebookSDK 
}