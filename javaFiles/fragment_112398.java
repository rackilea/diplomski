import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
public class Eval {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager s = new ScriptEngineManager();
        ScriptEngine engine = s.getEngineByName("JavaScript");

        int x = 1;
        int y = 2;
        char z = '+';

        String exp = "" + x + z + y;
        System.out.println(engine.eval(exp));
    }    
}