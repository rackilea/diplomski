buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.6'
    }
    ...
}

apply plugin: 'application'

applicationDefaultJvmArgs = ["-Djava.library.path=optimization/lib"]

mainClassName = 'com.package.name.MainClass'