buildscript {
  ext.kotlin_version = '1.1.2-3'
  repositories {
    jcenter()
  }
  dependencies {
    classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
  }
}

allprojects {
  repositories {
    jcenter()
  }
}