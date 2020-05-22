ScriptEngine engine = mgr.getEngineByExtension("js");
try {
    System.out.println(engine.eval("5 * 8 + 2"));
} catch (ScriptException ex) {
    ex.printStackTrace(System.err);
}