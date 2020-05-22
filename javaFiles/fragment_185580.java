plugins {
    id 'java'
    id "io.spring.dependency-management" version "1.0.6.RELEASE"
}

group 'xyz.transformercli'
version '1.0-SNAPSHOT'

sourceCompatibility = 11

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom 'io.micronaut:micronaut-bom:1.0.3'
    }
}

dependencies {
    annotationProcessor "io.micronaut:micronaut-inject-java"
    //my jar with base classes
    compile files('libs/transformer-cli-0.1.jar')
    compile "io.micronaut:micronaut-inject"
}