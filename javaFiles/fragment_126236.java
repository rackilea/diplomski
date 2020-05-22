task wsimport {
    doLast {
        def wsdlPaths = ["path1", "path2", "path3"]

        wsdlPaths.each { wsdlPath ->
            ant {
                // replace this with your current code as appropriate
                echo(message: "path is ${wsdlPath}")
            }
        }
    }
}