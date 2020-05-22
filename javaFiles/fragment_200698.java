if(project.hasProperty('javaVer') && javaVer == '8') {
    sourceCompatibility = 1.8
    targetCompatibility = 1.8
}

afterEvaluate {
    repositories {
        mavenCentral()
        jcenter()
        flatDir {
            dirs 'lib'
        }
    }
    compileJava {
        if (project.hasProperty(('javaVer')) && javaVer == '8') {
            excludes = ['**/module-info.java']
        } else {
            doFirst {
                options.compilerArgs = [
                        '--module-path', classpath.asPath,
                ]
                classpath = files()
            }
        }
    }
}