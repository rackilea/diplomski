task callCL(type: Exec) {

        executable "bash"
        args "-c", "bash /build/distributions/WebLargeTests/bin/WebLargeTests -f html:build/reports/cucumber/ -f json:build/reports/cucumber/report.json --glue com.waze.testing.cucumber src/main/resources/features --tags @only -f rerun"


        // If you want the store the output to a file, you can also try the following
        //args "-c", "bash /build/distributions/WebLargeTests/bin/WebLargeTests -f html:build/reports/cucumber/ -f json:build/reports/cucumber/report.json --glue com.waze.testing.cucumber src/main/resources/features --tags @only -f rerun 1>/some/path/somefile.log 2>&1"

        //store the output instead of printing to the console:
        standardOutput = new ByteArrayOutputStream()

        //extension method stopTomcat.output() can be used to obtain the output:
        ext.output = {
           return standardOutput.toString()
        }
}