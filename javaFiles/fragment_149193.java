ext.moduleName = 'your.module'

compileJava {
    inputs.property('moduleName', moduleName)
    doFirst {
        options.compilerArgs = [
            '--module-path', classpath.asPath
        ]
        classpath = files()
    }
}