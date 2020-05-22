jar {
    manifest {
        attributes(
            "Class-Path": configurations.runtime.collect { "lib/$it.name" }.join(' ')
        )
    }
}