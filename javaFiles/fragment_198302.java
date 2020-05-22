task runApp(type: JavaExec) {
    classpath = sourceSets.main.runtimeClasspath

    main = 'nicebank.AtmServer'

}