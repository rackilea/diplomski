package rhinodemo;

  import java.util.Date;
  import javax.script.*;

  public class RhinoDemo {

    public static void main(String[] args) throws Exception {
      ScriptEngineManager mgr = new ScriptEngineManager();
      ScriptEngine engine = mgr.getEngineByName("JavaScript");

      Bindings bindings = engine.createBindings();
      bindings.put("currentTime", new Date());
      engine.eval(
         "function run(x) { println('x=' + x); }" +
         "run(currentTime);", bindings);
    }
  }