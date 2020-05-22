buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath group: 'com.github.jengelman.gradle.plugins', name: 'shadow', version: '1.2.4'
    }
}

apply plugin: 'com.github.johnrengelman.shadow'

project.version = '1.0.0-alpha.2'
project.group = 'com.domhauton.membrane'

jar {
    baseName = 'membrane-daemon'
    version = project.version
    manifest {
        attributes 'Implementation-Title': 'Membrane Daemon',
                'Implementation-Version': project.version,
                'Main-Class': project.group + '.Main'
    }
}