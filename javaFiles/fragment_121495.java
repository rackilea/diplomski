@Test
public void mapDelete() throws ScriptException {
    Map<String,String> map = new HashMap<>(1);
    map.put("key","value");

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
    engine.getContext().getBindings(ScriptContext.GLOBAL_SCOPE).put ("testMap", map);
    engine.eval("testMap.remove('key');");
    Assert.assertEquals (0, map.size());
}