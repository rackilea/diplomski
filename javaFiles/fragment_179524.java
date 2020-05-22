package de.lhorn.so;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.JSObject;

public class SOPlayground {

    public static void main(String[] args) throws Exception {
        SOPlayground sop = new SOPlayground();
        JSObject jso = sop.execute();
        System.out.println("value=" + jso.getMember("value"));
        System.out.println("count=" + jso.getMember("count"));
    }

    public JSObject execute() throws ScriptException, NoSuchMethodException {
        final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        final Compilable compilable = (Compilable) engine;
        final Invocable invocable = (Invocable) engine;

        final String statement =
          "function fetch(value, count) { count++ ; return {value: value, count : count} };";
        final CompiledScript compiled = compilable.compile(statement);

        compiled.eval();

        return (JSObject) invocable.invokeFunction("fetch", 10, 2);
    }
}