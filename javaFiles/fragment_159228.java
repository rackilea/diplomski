ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("JavaScript");
    engine.eval("function x() { return { foo: 10 } }");

    Object o = ((Invocable)engine).invokeFunction("x");
    if (o instanceof Map) {
    Map m = (Map<Object, Object>)o;
        System.out.println(m.get("foo"));
    }