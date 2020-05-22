buildscript {
    repositories {
        maven { url "https://maven.eveoh.nl/content/repositories/releases" }
    }

    dependencies {
        classpath "nl.eveoh:gradle-aspectj:1.4"
    }
}

project.ext {
    aspectjVersion = '1.8.1'
}

apply plugin: 'java'
apply plugin: 'aspectj'
apply plugin: 'application'

repositories {
    mavenCentral()
}

dependencies {
    compile 'org.perf4j:perf4j:0.9.16:log4jonly'
    compile 'org.aspectj:aspectjrt:1.8.1'
    compile 'commons-jexl:commons-jexl:1.1'
    compile 'log4j:log4j:1.2.17'

    ajInpath 'org.perf4j:perf4j:0.9.16:log4jonly'
}

sourceCompatibility = '1.8'
mainClassName = 'com.mycompany.testapplication.TestClass'