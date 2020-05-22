buildscript {
    repositories {
        mavenCentral()
        maven { url 'https://plugins.gradle.org/m2/' }
        jcenter()
    }
}

plugins {
    id 'com.github.johnrengelman.shadow' version '1.2.4'
    id "com.bmuschko.clover" version "2.1.3"
}

apply from: 'gradle/util.gradle'

subprojects {
    apply plugin: 'eclipse'
    apply plugin: 'idea'
    apply plugin: 'java'
    apply plugin: 'maven'
    apply plugin: 'com.github.johnrengelman.shadow'
    apply plugin: 'com.bmuschko.clover'

    group = 'com.myproject'
    version = '0.0.1-SNAPSHOT'

    idea {
        module {
            scopes.PROVIDED.plus += [configurations.shadow]
        }
    }

    tasks.build.dependsOn(shadowJar)
    artifacts.archives shadowJar

    tasks.withType(AbstractCompile) {
        classpath += configurations.shadow
    }

    ext {
        mockito = '2.9.0'
        junit = '4.12'
        powermock = '1.7.3'
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        // testCompile dependencies
        testCompile group: 'org.mockito', name: 'mockito-core', version: mockito
        testCompile group: 'junit', name: 'junit', version: junit
        testCompile group: 'org.powermock', name: 'powermock-api-mockito2', version: powermock
        testCompile group: 'org.powermock', name: 'powermock-module-junit4', version: powermock
        clover 'org.openclover:clover:4.2.0'
    }

    jar {
        archiveName = "${project.name}-slim.jar"
    }

    shadowJar {
        archiveName = "${project.name}.jar"
    }

    install {
        repositories.mavenInstaller {
            pom.artifactId = "sdk-${project.name}"
        }
    }
}