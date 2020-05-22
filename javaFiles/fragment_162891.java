task generateMySources(type: Jar) {
    classifier = 'sources'
    from android.sourceSets.main.java.srcDirs
}
task addMySourcesToAar(type: Jar) {
    archiveName "myModuleWithSources.aar"
    destinationDir file("build")
    from zipTree("build/outputs/aar/myModule-release.aar")
    from fileTree("build").include("libs/myModule-sources.jar")
}
afterEvaluate { project ->
    project.tasks.preBuild.dependsOn generateMySources
    project.addMySourcesToAar.dependsOn build
}
artifacts {
    archives addMySourcesToAar.archivePath
}