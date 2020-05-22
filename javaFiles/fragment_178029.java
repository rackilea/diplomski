// create a script engine manager
ScriptEngineManager factory = new ScriptEngineManager();
// create a JavaScript engine
ScriptEngine engine = factory.getEngineByName("JavaScript");

Double d=(Double)engine.eval("1 + 2 * 3");
System.out.println(d);