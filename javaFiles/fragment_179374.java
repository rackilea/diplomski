jar {
    manifest {
        attributes(
           "Main-Class": "com.Remo.server.RemoServerApp",
           "Class-Path": configurations.runtime.files.collect { it.getName() }.join(' '))
         )
    }
}