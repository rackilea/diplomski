public abstract class C1 {
   private Map<String, String> params;
   public C1(Map<String, String> params) { this.params = params; }
}

public class C2 extends C1 {
   public C2(String a, String b) {
      super (new HashMap<String, String>() {{
                 put("a", a);
                 put("b", b);
             }});
   }
}

public class C3 extends C1 {
   private HashMap<String, String> myMap = new HashMap<>();

   public C3() {
      super (myMap);
      // now put values into myMap based on user input.
   }
}