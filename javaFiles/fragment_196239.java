import javax.script.*;

public class Main {

  public static void main (String[] args) throws Exception {

    String source =
        "var system = new Array();                       \n" +
        "system['foo'] = function(s) { return 'hello'; } \n" +
        "                                                \n" +
        "var results = system.foo('example');            \n" +
        "                                                \n" +
        "if(results == \"hello\") {                      \n" +
        "  print(\"ding dong.\");                        \n" +
        "}                                               \n";

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
    engine.eval(source);
  }
}