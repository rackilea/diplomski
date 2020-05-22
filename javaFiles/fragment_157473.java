apply plugin: 'java'
apply plugin: 'com.github.johnrengelman.shadow'

mainClassName = 'org.myapp.Main'

jar {
    manifest {
        attributes('Main-Class': mainClassName)
    }
}

buildscript {
    repositories { jcenter() }
    dependencies {
        classpath 'com.github.jengelman.gradle.plugins:shadow:1.2.2'
    }
}

repositories { jcenter() }
dependencies {
    compile 'org.slf4j:slf4j-api:1.7.13'
    compile 'org.apache.commons:commons-math3:3.6'

    testCompile 'junit:junit:4.12'
}