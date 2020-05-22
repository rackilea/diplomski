List<Map<String, String>> listOfMap = dropActiveStatus(listOfMapInout);

RuleApplier applierA = new RuleApplier(Rules::f1, Rules::f2, Rules::f3, Rules::f4);
List<Map<String, String>> listOfMapOutA = applierA.apply(listOfMap);

RuleApplier applierB = new RuleApplier(Rules::f5, Rules::f6);
List<Map<String, String>> listOfMapOutB = applierB.apply(listOfMap);