// Your app's build.gradle
apply plugin: 'com.android.app'

// Your app's build.gradle    apply plugin: 'com.android.app'

android {
   compileSdkVersion 27
   defaultConfig {
     appId "com.google.example.64bit"
     minSdkVersion 15
     targetSdkVersion 28
     versionCode 1
     versionName "1.0"
     ndk.abiFilters 'armeabi-v7a', 'arm64-v8a', 'x86', 'x86_64'   
// ...