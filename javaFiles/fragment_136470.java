apply plugin: 'ear'
apply plugin: 'java'


description = 'JavaEE6 Assembly'
dependencies {
  deploy project(path: ':WAR1', configuration: 'archives')
  deploy project(path: ':WAR2', configuration: 'archives')
  deploy project(path: ':WAR3', configuration: 'archives')

  earlib project(':CommonJAR')



}

def deployedModules = [ 'WAR1', 'WAR2', 'WAR3' ]

deployedModules.forEach {
    def projectPath = ":${it}"

    evaluationDependsOn(projectPath)

    findProject(projectPath).configurations.providedCompile.allDependencies.forEach {
        boolean isEarModule = it instanceof ProjectDependency &&
                (it as ProjectDependency).dependencyProject.name in deployedModules
        if (!isEarModule) {
            dependencies.add('earlib', it)
        }
    }
}

ear {
     archiveName='EARNAME.ear'
     libDirName 'lib'
     into("META-INF"){
        from("META-INF") 
     }
}