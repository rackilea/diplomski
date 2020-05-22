NodeList allTests = (NodeList) xPath.evaluate("/xml/Test", xmlDocument, XPathConstants.NODESET);
    for (int i = 0; i < tests.getLength(); i++) {
        Element singleTest = (Element) tests.item(i);
        // Here, you can extract some values from your test like:
        // testOutcome = xPath.evaluate("Outcome/@value", singleTest);

        NodeList testResults = (NodeList) xPath.evaluate("TestResult",test, XPathConstants.NODESET);

        for (int j=0; j<testResults.getLength(); j++) {
            // Now you can iterate over all your testResults from test
            // testResultName = xPath.evaluate("@name",testResults.item(j)));
        }
    }