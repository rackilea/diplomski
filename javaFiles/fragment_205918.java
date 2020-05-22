apply plugin: 'java'
apply plugin: 'maven'
apply plugin: 'war'

targetCompatibility = 1.8
sourceCompatibility = 1.8
version = '0.0.1-SNAPSHOT'
group = 'com.s2d'

configurations {
  warApp
}

repositories {
  mavenCentral()
}

dependencies {
  providedCompile project(':echo-core')
  providedCompile group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
}

artifacts {
  warApp war
}