jar {
    from { configurations.compileClasspath.collect { it.isDirectory() ? it : zipTree(it) } }
    manifest {
        attributes 'Main-Class': 'jetliner.Main'
    }
}