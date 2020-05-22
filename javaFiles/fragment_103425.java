import javax.script.*;
import jdk.nashorn.api.scripting.JSObject;

public class Main {
   public static void main(String[] args) throws Exception {
      ScriptEngineManager m = new ScriptEngineManager();
      ScriptEngine e = m.getEngineByName("nashorn");

      // get JS "Object" constructor object
      JSObject objConstructor = (JSObject)e.eval("Object");

      // call 'newObject' on Object constructor
      JSObject jsObj = (JSObject) objConstructor.newObject();

      // fill properties of the new empty script object
      jsObj.setMember("foo", "bar");

      // expose the new JS object as global var!
      e.put("obj", jsObj);

      // print the object as a JSON string
      e.eval("print(JSON.stringify(obj))");
   }
}