public enum Test {
   MOSCOW(1001),
   NEWYORK(1002),
   SOCHI(1234);

   private final int cityId;

   private Test(int cityId) {
    this.cityId = cityId;
   }

   ...


   private static Map<Integer, Test> mapping = new HashMap<Integer, Test>();

   static { //executed when the class is loaded
     for( Test t : values() ) {
        mapping.put(t.getCityId(), t);
     }
   }

   public static toTest(int cityId) {
     return mapping.get(cityId);
   }
}