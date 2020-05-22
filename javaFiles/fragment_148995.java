import proguard.gradle.ProGuardTask

apply plugin: 'com.github.johnrengelman.shadow'
apply plugin: 'java'

buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }

  dependencies {
    classpath group: 'net.sf.proguard', name: 'proguard-gradle', version: '5.3.1'
    classpath group: 'com.github.jengelman.gradle.plugins', name: 'shadow', version: '1.2.4'
  }
}

repositories {
  mavenCentral()
  jcenter()
}

jar {
  manifest { attributes("Main-Class": "com.skcraft.launcher.Launcher") }
}

dependencies {
  compile 'org.projectlombok:lombok:1.12.2'
  compile 'com.fasterxml.jackson.core:jackson-databind:2.3.0'
  compile 'commons-lang:commons-lang:2.6'
  compile 'commons-io:commons-io:1.2'
  compile 'com.google.guava:guava:15.0'
  compile 'com.beust:jcommander:1.32'
  compile 'com.miglayout:miglayout:3.7.4'
  compile 'com.google.code.findbugs:jsr305:3.0.0'
}

processResources {
  filesMatching('**/*.properties') {
    filter {
      it.replace('${project.version}', project.version)
    }
  }
}

task obfuscate(type: proguard.gradle.ProGuardTask) {
  configuration 'proguard.txt'

  injars jar
  outjars "${buildDir}/libs/launcher-${version}-obf.jar"

  libraryjars files(configurations.compile.collect())
}

shadowJar {
  dependencies {
    exclude(dependency('org.projectlombok:lombok'))
  }
}

build.dependsOn(shadowJar)
build.dependsOn(obfuscate)


task wrapper(type: Wrapper) { gradleVersion = "3.1" }