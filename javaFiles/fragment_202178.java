plugins {
    id 'java'
    id 'org.javamodularity.moduleplugin' version '1.5.0'
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.6'
}

modularity.mixedJavaRelease 8