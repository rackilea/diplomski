plugins {
    id 'java-library'
    id 'groovy'
    id 'eclipse'
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.8'
}

mainClassName = 'core.App'
group 'Project'
version '1.0'
sourceCompatibility = 11

repositories {
    mavenCentral()
}

dependencies {
    api 'org.apache.commons:commons-math3:3.6.1'
    implementation 'com.google.guava:guava:27.0.1-jre'
    testImplementation 'junit:junit:4.12'
    implementation 'org.codehaus.groovy:groovy-all:2.5.8'
    testImplementation 'org.spockframework:spock-core:1.2-groovy-2.5'
}

javafx {
    version = "13"
    modules = [ "javafx.controls", "javafx.fxml" ]
}