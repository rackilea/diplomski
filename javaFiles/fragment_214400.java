apply plugin: 'java'

jar {
    manifest {
        attributes("Manifest-Version": "1.0",
                "Main-Class": "com.randomPackage.MainClass");
    }
}

task fatJar(type: Jar) {
    manifest.from jar.manifest
    classifier = 'all'
    from {
        configurations.runtime.collect { it.isDirectory() ? it : zipTree(it) }
    } {
        exclude "META-INF/*.SF"
        exclude "META-INF/*.DSA"
        exclude "META-INF/*.RSA"
    }
    with jar
}