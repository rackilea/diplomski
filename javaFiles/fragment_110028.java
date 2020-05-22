jar {
    // Will include every single one of your dependencies, project or not
    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
}