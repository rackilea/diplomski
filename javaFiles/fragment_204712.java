jar {
    manifest {
        attributes 'Main-Class': 'eliteDangerousRestUpdater.Main'
    }
    from {
        compileJava.classpath.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
}