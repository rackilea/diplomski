task fatJar(type: Jar) {
    manifest {
        attributes 'Main-Class': 'Application'
    }
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    with jar
}