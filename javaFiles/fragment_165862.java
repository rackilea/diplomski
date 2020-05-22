jar {
    manifest {
        attributes 'Main-Class': 'HelloKotlinKt'
    }

    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
}