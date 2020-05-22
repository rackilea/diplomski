plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.7'
    id 'com.github.onslip.gradle-one-jar' version '1.0.5'
}

repositories {
    jcenter()
}

dependencies {
    implementation 'com.jfoenix:jfoenix:9.0.8'
    implementation group: 'commons-validator', name: 'commons-validator', version: '1.6'
    implementation group: 'commons-io', name: 'commons-io', version: '2.6'
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '3.141.59'
    implementation group: 'org.apache.commons', name: 'commons-lang3', version: '3.8.1'
    implementation group: 'com.sun.mail', name: 'javax.mail', version: '1.6.2'
    implementation group: 'io.reactivex.rxjava2', name: 'rxjava', version: '2.2.5'
    testImplementation group: 'junit', name: 'junit', version: '4.12'
}

javafx {
    modules = [ 'javafx.controls', 'javafx.fxml' ]
}

mainClassName = 'jetliner.Launcher'

jar {
    manifest {
        attributes 'Main-Class': 'jetliner.Launcher'
    }
    from {
        configurations.compileClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
}

task awesomeFunJar(type: OneJar) {
    mainClass = 'jetliner.Main'
}