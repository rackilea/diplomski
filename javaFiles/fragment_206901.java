task jacocoJupTestReport(type: JacocoReport) {
    executionData(test)
    sourceSets(sourceSets.main)
    sourceDirectories = files(sourceSets.main.allSource.srcDirs)
    classDirectories = files(sourceSets.main.output)

    reports {
        xml.enabled true
        xml.destination file("${buildDir}/reports/jacoco/report.xml")
        html.enabled false
        csv.enabled false
    }

    jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    counter = 'INSTRUCTION'
                    value = 'COVEREDRATIO'
                    minimum = project.properties["minimumValue"]
                }
            }
        }
    }
}