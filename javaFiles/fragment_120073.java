jacoco {
    toolVersion = "0.8.3"
    reportsDir = file("$buildDir/customJacocoReportDir")
}

jacocoTestReport {
    reports {
        xml.enabled true
        html.enabled true
        csv.enabled false
        html.destination file("$buildDir/customJacocoReportDir/test/html")
        xml.destination file("$buildDir/customJacocoReportDir/test/jacocoTestReport.xml")
    }
}

sonarqube {
    properties {
        // define your properties
        property "sonar.jacoco.reportPath", "$buildDir/jacoco/test.exec"
        property "sonar.coverage.jacoco.xmlReportPaths", "$buildDir/customJacocoReportDir/test/jacocoTestReport.xml"
    }
}