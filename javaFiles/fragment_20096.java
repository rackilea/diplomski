task run(dependsOn: classes, type: JavaExec) {
    main = project.hasProperty('mainClass') ? project.mainClass : ''
    classpath = sourceSets.main.runtimeClasspath
    standardInput = System.in

    if (project.hasProperty('runWorkingDir')) {
        workingDir = new File(project.runWorkingDir)
    }
}