import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class LuaTest {
    public static void main(String[] args) throws Exception {
        String scriptFilePath = "/Users/developer/work/luaj-2.0.2/examples/lua/hello.lua";

        Reader reader = new FileReader(new File(scriptFilePath));
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine e = mgr.getEngineByExtension(".lua");
        Object result = e.eval(reader);
    }
}