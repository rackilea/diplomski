group 'com.test'
version '1.0-SNAPSHOT'

apply plugin: 'java'
apply plugin: 'application'

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  compile 'io.simplepush:project1-sample:1.1'
}

mainClassName = "Hello"