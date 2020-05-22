buildscript {
        repositories {
            mavenCentral()
            mavenLocal()
        }
        dependencies {
            classpath "net.ltgt.gradle:gradle-errorprone-plugin:0.0.9"
            classpath 'com.github.jengelman.gradle.plugins:shadow:1.2.4'
            classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.0'
        }
    }

    plugins {
        id 'java'
        id 'application'
        id 'idea'
        id 'com.github.johnrengelman.shadow' version '1.2.4'
        id "net.ltgt.errorprone" version '0.0.9'
    }


    shadowJar {
        baseName = 'shadow'
        classifier = null
        version = null
    }

jar {
    manifest {
        attributes(
                'Class-Path': configurations.runtime.files.collect {"$it.name"}.join(' '),
                'Main-Class': 'com.abc.test'
        )
    }
}