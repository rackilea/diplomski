test {
    reports {
        junitXml.enabled = true
        html.enabled = false
        reports.junitXml.destination = file("test-output/reports/")
    }
    useTestNG()
            {
                useDefaultListeners = true
                options.suites("src/test/java/testApi_Test_Scripts/smsApiAutomationSuite.xml")
                options.listeners << 'com.kaleyra.smsApi.qa.framework.listener.CustomListener'
                //options.listeners << 'com.kaleyra.smsApi.qa.framework.listener.EmailListener'
                //options.listeners << 'org.uncommons.reportng.HTMLReporter'
                options.listeners << 'org.uncommons.reportng.JUnitXMLReporter'
                systemProperty 'org.uncommons.reportng.title', 'sms_api_automation_results'

            }
    testLogging.events "passed", "skipped", "failed"
    testLogging.showStandardStreams = true
    testLogging.exceptionFormat = "full"