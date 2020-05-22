private static void log(String msg, Object obj) {
    System.out.println(msg + " " + obj);
}

public static void main(String[] args) throws ScriptException {
    ScriptEngineManager manager = new ScriptEngineManager();
    Bindings bindings = new SimpleBindings();
    bindings.put("a", 3);
    bindings.put("org", 10);
    log("bingings-org", bindings.get("org"));
    manager.setBindings(bindings);

    ScriptEngine engine = manager.getEngineByName("JavaScript");
    log("global-a", engine.getBindings(ScriptContext.GLOBAL_SCOPE).get("a"));
    log("local-a", engine.get("a"));
    log("global-org", engine.getBindings(ScriptContext.GLOBAL_SCOPE).get("org"));
    log("local-org", engine.get("org"));
    // "org" in ENGINE_SCOPE hides GLOBAL_SCOPE "org".
    // delete the "org" in ENGINE_SCOPE
    // you could delete "org" from Java code as well using
    // "remove" method of Bindings object
    engine.eval("delete org");
    System.out.println("after deleting ENGINE_SCOPE org");
    log("local-org", engine.get("org"));
}