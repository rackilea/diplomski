task preprocessClassesForJacoco(dependsOn: ['classes']) {
        ext.outputDir = buildDir.path + '/classes-instrumented'
        doLast {
            ant.taskdef(name: 'instrument',
                    classname: 'org.jacoco.ant.InstrumentTask',
                    classpath: configurations.jacoco.asPath)
            ant.instrument(destdir: outputDir) {
                fileset(dir: sourceSets.main.java.outputDir, includes: '**/*.class', erroronmissingdir: false)
            }
        }
    }