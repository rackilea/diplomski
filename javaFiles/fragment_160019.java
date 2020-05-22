["source1", "source2", "source3"].each{ sourceName ->
    tasks.create("pmd${sourceName}", Pmd){
        reports.html.reportsDir = "$buildDir/reports/pmd${sourceName}"

        source = zipTree("file/to/$sourceName.zip")
        ...
    }
}