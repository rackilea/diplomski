import java.util.*;
import javax.script.*;
import jdk.nashorn.api.scripting.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ScriptEngineManager m = new ScriptEngineManager();
    ScriptEngine e = m.getEngineByName("nashorn");

    // Java array accessed by indexing
    String[] arr = { "hello", "world" };
    e.put("jarr", arr);
    e.eval("jarr[1] = jarr[1].toUpperCase()"); // change first element
    System.out.println(arr[1]); // change reflected here

    // Java ArrayList accessed by indexing
    ArrayList<String> alist = new ArrayList<>();
    alist.add("nashorn");
    alist.add("javascript");
    e.put("jlist", alist);
    e.eval("jlist[0] = 'Nashorn'");
    System.out.println(alist.get(1)); // change reflected here

    // Third case - a JSObject array-like object accessed by indexing
    e.put("myObj", new AbstractJSObject() {
        private Map<Integer, Object> values = new HashMap<>();
        @Override
        public void setSlot(int index, Object val) {
            values.put(index, val);
        }

        @Override
        public Object getSlot(int index) {
            return values.get(index);
        }
   });

   e.eval("myObj[0] = 'hello'");
   e.eval("print(myObj[0])");
 }
}