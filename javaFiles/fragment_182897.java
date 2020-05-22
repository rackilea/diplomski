jar {
    from(configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }) {
        exclude "META-INF/*.SF"
        exclude "META-INF/*.DSA"
        exclude "META-INF/*.RSA"
    }
    manifest {
        attributes 'Main-Class': 'com.domain.scaffolding.Main'
    }
}