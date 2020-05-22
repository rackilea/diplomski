import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {
    public static void main(String[] args) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.put("minimumBet", "{\"SEK\":1,\"EUR\":2}");
            engine.eval("var bet = JSON.parse(minimumBet);");
            engine.eval("var krona = bet['SEK'];");
            engine.eval("var euro = bet['EUR'];");
            Object krona = engine.get("krona");
            Object euro = engine.get("euro");
            System.out.println(krona + " " + krona.getClass());
            System.out.println(euro + " " + euro.getClass());
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
    }
}