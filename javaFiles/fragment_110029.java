buildscript {
    dependencies {
        classpath 'com.github.jengelman.gradle.plugins:shadow:4.0.2'
    }
}

apply plugin: 'com.github.johnrengelman.shadow'    

...

// Outputs to build/libs/dolphin-web-<version>.jar
shadowJar {
   baseName = 'dolphin-web'
   classifier = null
   version = getVersionCode()
}