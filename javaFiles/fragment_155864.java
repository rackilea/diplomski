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

    // Use "context" to access GLOBAL_SCOPE "org" from script
    engine.eval(
        "var GLOBAL_SCOPE = javax.script.ScriptContext.GLOBAL_SCOPE;\n" +
        "var g = context.getBindings(GLOBAL_SCOPE);\n" +
        "print(g.get('org'))"); 
}