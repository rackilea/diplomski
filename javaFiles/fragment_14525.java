import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class Main {
  public static void main(String[] args) throws Exception{
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    String expression = "100+200/100*2";
    System.out.println(engine.eval(expression));
    } 
}