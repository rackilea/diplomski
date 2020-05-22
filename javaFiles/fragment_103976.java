jar {
    doFirst {
        manifest {
            attributes(
                "Class-Path": libDir.listFiles().collect { 'lib/' + it.getName() }.join(' ')
            )
        }
    }
}