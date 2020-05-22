sonarqube {
        properties {
            property "sonar.java.coveragePlugin", "jacoco"
            property("sonar.coverage.jacoco.xmlReportPaths", "../../build/reports/jacocoTestReport.xml,../build/reports/jacocoTestReport.xml")
        }
}