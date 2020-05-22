plugins {
    id 'java'
    id "io.freefair.aspectj.post-compile-weaving" version "4.1.4"
}

group 'com.amdocs'
version '1.0.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    compile group: 'org.projectlombok', name: 'lombok', version: '1.18.10'
    annotationProcessor "org.projectlombok:lombok:1.18.10"
}