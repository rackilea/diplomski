ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("javascript");
SimpleBindings bindings = new SimpleBindings();

bindings.put("a", 0);
bindings.put("b", 6);

boolean firstEval =  (Boolean) scriptEngine.eval("a != 0 && b > 5", bindings);
System.out.println(firstEval);

bindings.put("a", 2);
bindings.put("b", 6);

boolean secondEval =  (Boolean) scriptEngine.eval("a != 0 && b > 5", bindings);
System.out.println(secondEval);