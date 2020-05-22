task renameArtifacts (type: Copy) {
    from ('project/')
    include 'project-1.5.jar'
    destinationDir file('project/')
    rename 'project-1.5.jar', "project.jar"
}