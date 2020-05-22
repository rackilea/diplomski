task fatJar(type: Jar) {
    manifest {
        attributes 'Implementation-Title': 'Gradle Jar File',
                   'Implementation-Version': version,
                   'Main-Class': 'path.classname'
    }
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    with Jar
}