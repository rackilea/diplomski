import javax.script.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ScriptEngineManager m = new ScriptEngineManager();
    ScriptEngine e = m.getEngineByName("nashorn");

    // get the java static method to call
    e.eval("var getProp = java.lang.System.getProperty");
    // direct call
    e.eval("print(getProp('java.home'))");

    // call using Function.prototype.call
    e.eval("print(Function.prototype.call.call(getProp, null, 'java.home'))");

    // a java object
    e.eval("var out = java.lang.System.out");
    // get an instance method
    e.eval("var p = out.println");
    // call java instance method using Function.prototype.call
    e.eval("Function.prototype.call.call(p, out, 'hello world')");
  }
}