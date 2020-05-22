Map variables = new HashMap();
  variables.put("ANGLE", "3.0");
  variables.put("PI", "3.14");

  Evaluator evaluator = new Evaluator();
  evaluator.setVariables(variables);

  String result = evaluator.evaluate("#{ANGLE} * #{PI} / 2"));