task uberJar(type: Jar, dependsOn: subprojects.assemble) {
    subprojects.each { project ->
        from project.configurations.archives.allArtifacts.files.collect { zipTree(it) }
    }

    manifest {
        attributes 'Main-Class': '<your-main-class>'
    }
}