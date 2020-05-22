jar {
    dependsOn(':frontend:build')

    into('public') {
        from "${project(':frontend').projectDir}/www"
    }
}