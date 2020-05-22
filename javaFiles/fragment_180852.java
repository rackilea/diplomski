import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptEngineSample {

    public static class MyClass {
        private String name;

        public String getName() { return name; }
        public void setName(final String name) { this.name = name; }
    }

    public static void main(final String[] args) throws ScriptException {
        final MyClass my = new MyClass();
        my.setName("Input");

        final ScriptEngineManager factory = new ScriptEngineManager();

        // you could also use 'javascript' here, I'm using 'nashorn' to visualize that I'm using the new Java 8 Engine
        final ScriptEngine engine = factory.getEngineByName("nashorn");

        engine.put("my", my);

        String script = "java.lang.System.out.println(my.getName());";
        script += "my.setName('Output');";

        engine.eval(script);

        System.out.println(my.getName());
    }
}