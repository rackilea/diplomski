import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class ExpressionEvaluator {

  private ExpressionEvaluator instance;
  private ScriptEngineManager scrEngMng;
  private ScriptEngine engine;

  private ExpressionEvaluator()
  {
    scrEngMng = new ScriptEngineManager();
    engine = scrEngMng.getEngineByName("JavaScript");
  }

  public static ExpressionEvaluator getInstance()
  {
    if(instance == null)
    {
       instance = new ExpressionEvaluator();
    }
    return instance;
  }

  public String eval(String expr) throws Exception{    
     return engine.eval(expr).toString();
   } 
}