import javax.script.*;

public class NashornVariables {
    public static class SomeJavaClass {
        public void doSomething() {
            System.out.println("I did something!");
        }
    }

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        manager.getBindings().put("x", new SomeJavaClass());
        ScriptEngine engine = manager.getEngineByName("nashorn");
        engine.eval(
            "x.doSomething();"
        );
    }
}