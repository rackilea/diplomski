KieServices ks = KieServices.Factory.get();
KieModuleModel kieModel = ks
    .newKieModuleModel()
    .setConfigurationProperty("drools.evaluator.precedes", PrecedesEvaluatorDefinition.class.getName());

KieBase kieBase = new KieHelper()
    .setKieModuleModel(kieModel)
    .addFromClassPath("/drools/Repetitions.drl")
    .build();