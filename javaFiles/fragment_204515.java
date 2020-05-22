configurations {
    externalClasses 
    externalSources
}

dependencies {
    externalClasses "externalpackage:externalpackage-model:0.0.8@jar"
    externalSources "externalpackage:externalpackage-model:0.0.8:sources@jar"        
    ...
}

buildscript {
... 
    dependencies {
    ...     
        classpath 'externalpackage:externalpackage-model'
    ...
    }   
}

compile('externalpackage:externalpackage-model:0.0.8')  
testCompile('externalpackage:externalpackage-model:tests@jar')
testCompile('externalpackage:externalpackage-model:0.0.8:sources@jar')

jacoco {
    toolVersion = "0.7.6.201602180812"
    reportsDir = file("$buildDir/customJacocoReportDir")
}

task unzipExternalModel(type: Copy){
    from zipTree(configurations.externalSources.files.first())
    into "$buildDir/tmp/externalSources"
    from zipTree(configurations.externalClasses.files.first())
    into "$buildDir/tmp/externalClasses"
}

jacocoTestReport {
    dependsOn unzipExternalModel
    reports {
        xml.enabled true
        csv.enabled true
        html.enabled true
        html.destination "${buildDir}/jacocoHtml"        
    }   
    additionalSourceDirs = files("$buildDir/tmp/externalSources")
    additionalClassDirs = files("$buildDir/tmp/externalClasses") 
}