jar {
    manifest {
        attributes(
                'Main-Class': 'com.package.YourClass'
        )
    }
    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
 }