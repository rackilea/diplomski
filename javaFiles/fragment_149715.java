import javax.script.*;
import jdk.nashorn.api.scripting.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager m = new ScriptEngineManager();
        ScriptEngine e = m.getEngineByName("nashorn");
        e.put("obj", new AbstractJSObject() {
            @Override
            public boolean hasMember(String name) {
                System.out.println("hasMember called for " + name);
                return false;
            }
        });
        // in operator triggers hasMember call on JSObject instance
        e.eval("if ('foo' in obj) print('yes')");
    }
}