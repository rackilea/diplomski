import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import jdk.nashorn.api.scripting.JSObject;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager m = new ScriptEngineManager();
        ScriptEngine e = m.getEngineByName("nashorn");

        // get ECMAScript JSON.parse
        JSObject jsonParse = (JSObject)e.eval("JSON.parse");

        // initialize/retrieve JSON string here
        String str = "{ \"foo\": 42, \"bar\": { \"x\": \"hello\" } }";

        // call JSON.parse from Java
        Object parsed = jsonParse.call(null, str);

        // expose parsed object to script
        e.put("obj", parsed);

        // access parsed object from script
        e.eval("print(obj.foo)");
        e.eval("print(obj.bar.x)");
    }
}