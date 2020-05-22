task aWar(type: War, dependsOn: classes) {
  baseName = 'a.war'
  classpath = project.configurations.aRuntime
}

task bWar(type: War, dependsOn: classes) {
  baseName = 'b.war'
  classpath = project.configurations.bRuntime
}

artifacts {
   archives aWar, bWar
}