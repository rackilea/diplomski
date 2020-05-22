import javax.script.*;

public class Main {
   public static void main(String[] args) throws Exception {
       ScriptEngineManager m = new ScriptEngineManager();
       ScriptEngine e = m.getEngineByName("nashorn");

       // get JavaScript "global" object
       Object global = e.eval("this");
       // get JS "Object" constructor object
       Object jsObject = e.eval("Object");

       Invocable invocable = (Invocable)e;

       // calling Object.bindProperties(global, "hello");
       // which will "bind" properties of "hello" String object
       // to JS global object
       invocable.invokeMethod(jsObject, "bindProperties", global, "hello");

       // you're calling "hello".toUpperCase()"
       e.eval("print(toUpperCase())");
       // accessing bean property "empty" on 'hello' object
       e.eval("print(empty)");

       // just print all (enumerable) properties of global
       // you'll see methods, properties of String class
       // (which'd be called on "hello" instance when accessed)
       e.eval("for (var i in this) print(i)");
   }
}