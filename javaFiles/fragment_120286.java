gradle.taskGraph.whenReady { graph ->
        if (graph.hasTask(preprocessClassesForJacoco)) {
            tasks.withType(Test) {
                doFirst {
                    ...
                    // getting a module dependencies
                    def modulesDependencies = moduleDependencies(project)
                    // removing regular jars
                    classpath -= files(modulesDependencies.jar.outputs.files)
                    // adding instrumented jars
                    classpath += files(modulesDependencies.jacocoInstrumentedJar.outputs.files)
                }
            }
        }
    }