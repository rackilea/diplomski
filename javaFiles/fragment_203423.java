plugins {
    id 'groovy'
    id 'java'
    id 'com.github.johnrengelman.shadow' version '5.0.0'
}

apply plugin: 'groovy'

group 'com.victor'
version '1.0'

sourceCompatibility = 1.8
targetCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    compile 'org.codehaus.groovy:groovy-all:2.5.7'
    compile 'org.jsoup:jsoup:1.12.1'
    compile 'com.google.api-client:google-api-client:1.23.0'
    compile 'com.google.oauth-client:google-oauth-client-jetty:1.23.0'
    compile 'com.google.apis:google-api-services-sheets:v4-rev493-1.23.0'
    compile 'log4j:log4j:1.2.17'
    compile 'org.slf4j:slf4j-log4j12:1.7.18'
    testCompile 'junit:junit:4.12'

}

shadowJar {
    baseName 'application'
    manifest {
        attributes 'Main-Class': 'com.victor.application.Application'
    }
}