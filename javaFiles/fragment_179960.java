debug {
    if (project.hasProperty("isDebug")) {
       debuggable Boolean.valueOf(project['isDebug'])
    } else {
       debuggable true // default setting
    }
}