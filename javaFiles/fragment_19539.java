apply plugin: 'application'

run {
   if (project.hasProperty("runArgs")) {
      args project.runArgs.split()
   }
}