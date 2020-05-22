public void runTestCase(String tarSuite, String tarCase) throws Exception {

    String reportStr = "";

    SoapUI.setSoapUICore(new StandaloneSoapUICore(true));

    WsdlProject project = new WsdlProject("C:\\Users\\tshi\\Documents\\Maven Projects\\ASORT\\WebServiceResource\\Suncorp_Issuing-soapui-project.xml");

    List<TestSuite> suiteList = project.getTestSuiteList();

    for (TestSuite aSuiteList : suiteList) {

        String suiteName = aSuiteList.getName();

        List<TestCase> caseList = aSuiteList.getTestCaseList();
        //System.out.println("Test Suite: " + suiteName);

        if (suiteName.equals(tarSuite)) {

            for (TestCase aCaseList : caseList) {

                String caseName = aCaseList.getName();
                //System.out.println("Test Case: " + caseName);

                if (caseName.equals(tarCase)) {

                    long startTime = System.currentTimeMillis();

                    TestRunner runner = project.getTestSuiteByName(suiteName).getTestCaseByName(caseName).run(new PropertiesMap(), false);

                    long duration = System.currentTimeMillis() - startTime;

                    reportStr = reportStr + "\n\tTestCase: " + aCaseList.getName() + "\tStatus: " + runner.getStatus() + "\tReason: " + runner.getReason() + "\tDuration: " + duration;

                }

            }

        }

    }

    System.out.print(reportStr);

}