public class A {
   private final Map<String,Integer> myMap;

   public A() {
      Map<String,Integer> map = new HashMap<String,Integer>();
      map.put("a",0);
      map.put("b",0);
      this.myMap = Collections.unmodifiableMap(map);
   } 
}