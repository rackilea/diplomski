/* make the "compileOnly" configuration available */
plugins {
    id 'java'
}

/* add some demo dependencies to the project */
repositories {
    jcenter()
}
dependencies {
    compileOnly 'junit:junit:4.12'
    compileOnly 'org.slf4j:slf4j-simple:1.7.28'
}

task createZip(type: Zip) {
    // the "lib" directory in the ZIP file will only have all those dependency
    // files of the "compileOnly" configuration which belong to the
    // "junit:junit:4.12" module:
    def depOfInterest = dependencies.create('junit:junit:4.12')
    into('lib') {
        from configurations.compileOnly.resolvedConfiguration.getFiles({dep ->
            dep == depOfInterest
        })
    }

    // the "justForDemonstration" directory in the ZIP file will have all
    // dependency files of the "compileOnly" configuration, incl. SLF4J:
    into('justForDemonstration') {
        from configurations.compileOnly
    }
}