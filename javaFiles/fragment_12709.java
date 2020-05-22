jacocoTestReport{
    additionalSourceDirs.from = files(sourceSets.main.allJava.srcDirs)
    reports {
        html.enabled true
        xml.enabled false
        csv.enabled false
        html.destination file("build/reports/jacoco/html")
    }
    executionData.from = files('build/jacoco/test.exec')    
}