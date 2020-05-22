@Test
public void testC() throws ScriptException, NoSuchMethodException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    String script = "function one(map){\n"
            + "var entries=map.entrySet().toArray();\n"
            + "for(entry in entries){\n"
            + "print( entries[entry].getKey());\n"
            + "print( entries[entry].getValue());\n" + "}}";
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("keyOne", "valueOne");
    String functionName = "one";
    engine.eval(script);
    Invocable inv = (Invocable) engine;
    inv.invokeFunction(functionName, map);
}