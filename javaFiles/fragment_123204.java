apply plugin: 'com.android.application'

android {
compileSdkVersion 24
buildToolsVersion '24.0.0'
defaultConfig {
    applicationId "com.pokemongo.pokemon"
    minSdkVersion 16
    targetSdkVersion 24
    multiDexEnabled true
}

   dexOptions {
  //incremental = true;
  preDexLibraries = false
  javaMaxHeapSize "4g"
  }
buildTypes {
    release {

        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
}
compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_7
    targetCompatibility JavaVersion.VERSION_1_7
 }
productFlavors {
 }
 }

 dependencies {
compile fileTree(include: ['*.jar'], dir: 'libs')
testCompile 'junit:junit:4.12'
compile 'com.android.support:appcompat-v7:24.1.1'
compile 'com.google.android.gms:play-services:9.4.0'
compile 'com.android.support:multidex:1.0.1'
 }