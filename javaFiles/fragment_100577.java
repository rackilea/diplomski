// set up the kotlin-gradle plugin
buildscript {
    ext.kotlin_version = '1.1.2-2'

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

// apply the kotlin-gradle plugin
apply plugin: "kotlin"


// add kotlin-stdlib dependencies.
repositories {
    mavenCentral()
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
}

jar {
    manifest {
        //Define mainClassName as: '[your_namespace].[your_arctifact]Kt'
        attributes 'Main-Class': 'hello.HelloKt'
    }

    // NEW LINE HERE !!!
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
}