import javax.script.ScriptEngine;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
...
ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");
try {
    engine.eval("const a = 20;\n"
            + "print(a);");
} catch (ScriptException e) {
    e.printStackTrace();
}