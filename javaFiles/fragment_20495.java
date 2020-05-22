import com.sun.script.jruby.JRubyScriptEngine;
    .... other imports

public class ScriptEngine {

    private static ScriptEngine engine = new JRubyScriptEngine();

    public void run(final String script, final Map<String,Object> input) {
        final Bindings context = engine.createBindings();

        context.putAll(input);

        try {
            engine.eval(script,context);
        } catch (ScriptException e) {
            log.error("Failed to execute script: "+getScript(),e);
        }
    }

}