class SomeClass {
   public static HashMap<Object, Object> MAP;

   public synchronized static setMap(HashMap<Object, Object> m) {
     MAP = m;
   }
}