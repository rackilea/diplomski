kieSession = kieContainer.newKieSession();
// create a TestRule object: ExpectedResultCode is null
TestRule testrule = new TestRule();
// insert the TestRule object: ExpectedResultCode is still null
kieSession.insert(testrule);
// display TestRule's ExpectedResultCode, which is still null
System.out.println("Output of Result Code:" + testrule.getResultCode());
// fire the rules
kieSession.fireAllRules();