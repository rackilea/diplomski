jar {
    subprojects.each {
        from files(it.sourceSets.main.output)
    }
}

distributions {
    main {
        contents {
            exclude subprojects.jar.archivePath.name
        }
    }
}