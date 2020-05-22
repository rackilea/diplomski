task calculateServerPort {
  // calculate your port here
  // if you really need business logic in Java for calculation, you could use the javaExec task in here
  project.ext.myport = 8007 // make it available as project.property here
}

processResources {
  dependsOn(calculateServerPort)
  expand project.properties
}

bootRun {
    addResources = false
}