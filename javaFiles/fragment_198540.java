ext {
    tomcatStopPort = 8081
    tomcatStopKey = 'stopKey'
}

task doTomcatRun(type: org.gradle.api.plugins.tomcat.TomcatRun) {
    stopPort = tomcatStopPort
    stopKey = tomcatStopKey
    daemon = true
}

task doTomcatStop(type: org.gradle.api.plugins.tomcat.TomcatStop) {
    stopPort = tomcatStopPort
    stopKey = tomcatStopKey
}

task someTask(type: SomeGradleTaskType) {
    //do stuff
    dependsOn doTomcatRun
    finalizedBy doTomcatStop
}