import java.util.*;
import javax.script.*;
import jdk.nashorn.api.scripting.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ScriptEngineManager m = new ScriptEngineManager();
    ScriptEngine e = m.getEngineByName("nashorn");
    e.eval("var MyHashMap = Java.extend(java.util.HashMap, {})");
    e.eval("function createMyHashMap() { return new MyHashMap(); }");
    HashMap hm = (HashMap) ((Invocable)e).invokeFunction("createMyHashMap");
    System.out.println(hm);
  }
}