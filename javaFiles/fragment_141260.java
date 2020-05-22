plugins {
    id 'java'
    id 'application'
}

// Project specifics
version '1.0-SNAPSHOT'
group 'com.example'

sourceCompatibility = 1.8
project.mainClassName = "core.ExampleApp"

dependencies {
    testCompile 'junit:junit:4.12'
}

// Define the project source paths
sourceSets {
    main.java {
        srcDir 'core/src'
    }
    test.java {
        srcDir 'core/test'
    }
}

// Exclude all resources from the jar
jar {
    processResources.exclude('*')
}

// Allows the 'test' task to see the directories on the classpath
test {
    classpath += files('conf')
    classpath += files('res')
}

// Allows the 'run' task to see the directories on the classpath
run {
    classpath += files('conf')
    classpath += files('res')
}

// Adds the directories to classpath in the start scripts
// They will have '$APP_DIR/lib/' prepended so they need to be copied into 'dist/lib/'
startScripts {
    run {
        classpath += files('conf')
        classpath += files('res')
    }
}

// Copy 'conf' and 'res' into the 'dist/lib' directory
distributions {
    main {
        contents {
            from('conf').into("lib/conf")
            from('res').into("lib/res")
        }
    }
}