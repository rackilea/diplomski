project.ext.main = 'com.myapp.Main'

task play(){
    project.main = 'com.myapp.Playground'
    finalizedBy buildDocker
}

jar {
    manifest {
        attributes 'Main-Class': project.main
    }
}