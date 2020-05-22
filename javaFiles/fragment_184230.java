testPlanTree = SaveService.loadTree(in);

ResponseAssertion responseAssertion = new ResponseAssertion();
responseAssertion.setName("Response Assertion");
//configure the assertion according to your requirements
responseAssertion.setProperty(TestElement.TEST_CLASS, ResponseAssertion.class.getName());
responseAssertion.setProperty(TestElement.GUI_CLASS, AssertionGui.class.getName());

testPlanTree.add(responseAssertion);

SaveService.saveTree(testPlanTree, new FileOutputStream("/path/to/script/with/assertion.jmx"));