plugins {
    id 'groovy'
    id 'application'
    id 'com.github.johnrengelman.shadow' version '5.0.0'
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation 'org.codehaus.groovy:groovy-all:2.5.6'
    testImplementation 'org.spockframework:spock-core:1.2-groovy-2.5'
    implementation 'org.apache.commons:commons-email:1.5'
}

mainClassName = 'us.company.emailer.App'