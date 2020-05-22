task deploy(type: Sync) {
    into "$buildDir/deploy"
    for (subproject in subprojects) {
        from subproject.tasks.withType(Jar)
    }
}