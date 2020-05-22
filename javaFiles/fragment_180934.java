plugins {
  id 'java'
  id 'maven-publish'
}

sourceCompatibility = 1.5

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  compile 'commons-codec:commons-codec:1.10'
  compile 'org.apache.httpcomponents:httpcore:4.4.6'
  compile 'org.apache.httpcomponents:httpclient:4.5.3'
}

publishing {
  publications {
    maven(MavenPublication) {
      groupId 'io.simplepush'
      artifactId 'project1-sample'
      version '1.1'

      from components.java
    }
  }
}