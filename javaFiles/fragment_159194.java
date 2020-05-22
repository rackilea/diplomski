public class Runtime {

    private ScriptEngine engine;
    private CompiledScript compiledRuntime;

    public Runtime() {
        engine = new NashornScriptEngineFactory().getScriptEngine("-strict");
        String source = new Scanner(
            this.getClass().getClassLoader().getResourceAsStream("runtime/runtime.js")
        ).useDelimiter("\\Z").next();

        try {
            compiledRuntime = ((Compilable) engine).compile(source);
        } catch(ScriptException e) {
            ...
        }
    }

    ...
}