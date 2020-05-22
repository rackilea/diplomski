repositories {
     def androidHome = System.getenv("ANDROID_HOME")
     mavenCentral()
     maven {
         url "$androidHome/extras/android/m2repository/"
     }
}