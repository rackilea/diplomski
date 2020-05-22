repositories{    
 jcenter()
   flatDir {
     dirs 'libs'
   }
}

dependencies {
  compile (name:'LibBlinkID', ext:'aar')
}

android {
 packagingOptions {
  exclude 'META-INF/NOTICE'
  exclude 'META-INF/LICENSE'
 }
}