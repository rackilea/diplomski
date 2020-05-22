String code="echo 5+5;"; //sample bit of code
ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByExtension("php");
try {
    engine.eval(code);
} catch (ScriptException ex) {
    //catch statement
}