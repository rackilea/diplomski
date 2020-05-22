task stage(type: Copy, dependsOn: [clean, build]) {
    from jar.archivePath
    into project.rootDir
    rename {
        'app.jar'
    }
}
stage.mustRunAfter(clean)

clean << {
    project.file('app.jar').delete()
}