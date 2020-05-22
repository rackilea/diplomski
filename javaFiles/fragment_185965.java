buildscript {

  ext.kotlin_version = '1.2.71'

  repositories {
    mavenCentral()
  }
  dependencies {
    classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
  }
}

apply plugin: 'kotlin'
apply plugin: 'application'

mainClassName = 'MainKt'
defaultTasks 'run'

run{
  standardInput = System.in
}

repositories {
  mavenCentral()
}

dependencies {
  compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
}