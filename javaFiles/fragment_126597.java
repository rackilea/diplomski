import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
...
System.setProperty("nashorn.args", "--language=es6");
ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");
try {
    engine.eval("const a = 20;\n"
            + "print(a);");
} catch (ScriptException e) {
    e.printStackTrace();
}