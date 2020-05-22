RulesEngine  rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                          .withSkipOnFirstAppliedRule(true)
                          .build();

// add your rules in the RulesEngine
rulesEngine.registerRule(new A());
rulesEngine.registerRule(new B());
rulesEngine.registerRule(new C());

// execute the rules
rulesEngine.fireRules();