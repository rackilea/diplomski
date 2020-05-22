apply plugin: 'java'

task sqlj(type: SqljTask) {
    encoding = 'UTF-8'
    additionalArgs = ['-status']
    sqljDir = file('src/main/sqlj')
    generatedJava = file("$buildDir/sqlj/java")
    generatedResources = file("$buildDir/sqlj/resources")
}

compileJava.dependsOn sqlj

sourceSets {
    main {
        java { 
            srcDir sqlj.generatedJava
        }
        resources {
            srcDir sqlj.generatedResources
        }
    }
}