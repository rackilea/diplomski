apply plugin: 'java'

configurations {
    libDependency
}

jar {
    from {
        configurations.libDependency.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
}

dependencies {
    FileTree libs = fileTree(dir: 'libs', include: '*.jar')
    libDependency libs
    compile libs
}