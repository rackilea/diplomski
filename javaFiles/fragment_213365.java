buildscript {
  repositories {
    maven {
      url 'https://plugins.gradle.org/m2/'
    }
  }

  dependencies {
    classpath 'com.github.jengelman.gradle.plugins:shadow:1.2.3'
  }
}

apply plugin: 'java'
apply plugin: 'com.github.johnrengelman.shadow'

repositories {
  mavenCentral()
}

dependencies {
  compile 'com.google.guava:guava:19.0'
  compile 'com.google.inject:guice:4.1.0'
}

shadowJar {
  mergeServiceFiles()
  archiveName "service.jar"
  exclude "META-INF/*.SF"
  exclude "META-INF/*.DSA"
  exclude "META-INF/*.RSA"
  manifest {
    attributes(
               [
               'Main-Class': "service.Service",
               'Built-By': System.getProperty('user.name'),
               'Built-Date': new Date(),
               'Built-JDK': System.getProperty('java.version'),
               'Implementation-Version': 'version',
               'Implementation-Title': project.name,
               ] +
               project.configurations.compile.allDependencies.collect { d ->
                 [
                  ("dependency-${d.group.replaceAll('\\.','-')}".toString()):"$d.group:$d.name:$d.version"
                 ]
               }.sum()
    )
  }
}