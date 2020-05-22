import javax.script.*;
import java.util.Arrays;
public class Test {
  public static void main(String... args) throws ScriptException {
    ScriptEngineManager manager = new ScriptEngineManager();
    for (ScriptEngineFactory factory : manager.getEngineFactories()) {
      System.out.printf("%s %s: %s %s%n", factory.getLanguageName(), factory.getLanguageVersion(), factory.getEngineName(), factory.getNames());
    }
    ScriptEngine engine = manager.getEngineByName("Graal.js");
    if (engine != null) {
      Object result = engine.eval("typeof([] + 1)");
      System.out.println(result);
    }
  }
}