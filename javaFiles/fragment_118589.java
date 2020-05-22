sourceSets {
    main {
        compileClasspath += configurations.provided
        runtimeClasspath += configurations.provided
        runtimeClasspath = runtimeClasspath.filter { File file ->
            file.name ==~ "log4j-slf4j-impl-2.1.jar" ? null : file
        }
    }
    test {
        compileClasspath += configurations.provided
        runtimeClasspath += configurations.provided
        runtimeClasspath = runtimeClasspath.filter { File file ->
            file.name ==~ "log4j-slf4j-impl-2.1.jar" ? null : file
        }
    }
}