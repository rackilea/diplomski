QueryRequest testSetRequest = new QueryRequest(testCaseJsonObject.getAsJsonObject("TestSets"));
    testSetRequest.setFetch(new Fetch("Name", "FormattedID"));

    // Load the TestSet collection
    JsonArray testSetsOfTestCase = restApi.query(testSetRequest).getResults();

    for (int i=0; i<testSetsOfTestCase.length(); i++) {
        System.out.println("Name: " + testSetsOfTestCase.get(i).getAsJsonObject().get("Name") + testSetsOfTestCase.get(i).getAsJsonObject().get("FormattedID").getAsString());
    }