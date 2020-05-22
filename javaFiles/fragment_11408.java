ant.importBuild 'build.xml'

task getNextBuild(dependsOn : ivyBuildNumber) {
    doLast{
        def nextVersion = ant.properties['ivy.new.revision']
        println nextVersion
    }
}