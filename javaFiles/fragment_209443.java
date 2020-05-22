ScriptEngineManager engineManager = new ScriptEngineManager();
ScriptEngine engine = engineManager.getEngineByName("nashorn");
try {
  engine.eval("function multiply(x, y) { return x * y; }");
  System.out.println(engine.eval("multiply(3, 2);"));
} catch (ScriptException e) {
  e.printStackTrace();
}