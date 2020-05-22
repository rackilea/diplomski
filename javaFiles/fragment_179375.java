task fatJar(type: Jar) {
    manifest {
        attributes 'Implementation-Title': 'Gradle Jar File Example',  
            'Implementation-Version': version,
            'Main-Class': "com.Remo.server.RemoServerApp"
    }
    baseName = project.name

    //collect all dependencies
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    with jar
}