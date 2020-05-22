for( int i =... ){
    KieSession kSession = ...;
    List outList = new ArrayList<Boolean>();
    kSession.setGlobal("outList", outList);
    List rulesList = new ArrayList<Boolean>();
    kSession.setGlobal("rulesList", rulesList);
    rule1 = ...;
    kSession.insert(droolsIntroduction);
    kSession.fireAllRules();
    boolean result1 = ...;
    kSession.dispose();
}