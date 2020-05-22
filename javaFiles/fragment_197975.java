for(int i=0;i<3;i++)
        {
            List<String> suites = new ArrayList<String>();
            suites.add("testng.xml"); //path of .xml file to be run-provide complete path

            TestNG tng = new TestNG();
            tng.setTestSuites(suites);

            tng.run(); //run test suite
        }