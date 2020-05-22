import javax.script.*;
import jdk.nashorn.api.scripting.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ScriptEngineManager m = new ScriptEngineManager();
    ScriptEngine e = m.getEngineByName("nashorn");
    e.eval("function Point(x, y) { this.x = x; this.y  = y}");
    JSObject pointFunc = (JSObject)e.get("Point");
    JSObject pointObj =  (JSObject)pointFunc.newObject(43, 55);
    System.out.println(pointFunc.isInstance(pointObj));
    System.out.println(pointObj.getMember("x"));
    System.out.println(pointObj.getMember("y"));
  }
}