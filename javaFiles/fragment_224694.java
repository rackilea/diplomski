jar {
   manifest {
        attributes (
            'Main-Class': 'org.conlang.sources.transcriber.Transcriber')
    }
    from configurations.compile.collect { entry -> zipTree(entry) }
}