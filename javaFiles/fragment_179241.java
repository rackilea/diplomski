android {
   ...
   defaultConfig {
       multiDexEnabled true
       ...
   }
}

dependencies {
  // add dependency 
  compile 'com.android.support:multidex:1.0.1'
}

// ADD THIS AT THE BOTTOM
apply plugin: 'com.google.gms.google-services'