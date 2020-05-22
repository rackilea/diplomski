public enum ClassFactory {
     Class1() {
          @Override public void generate() { 
               System.out.println("I'm in Class 1."); 
          }
     },
     Class2() {
          @Override public void generate() { 
               System.out.println("I'm in Class 2."); 
          }
     };
     //template method
     public abstract void generate();

   private static final Map<Integer, ClassFactory > lookup
   = new HashMap<Integer, ClassFactory >();

   static {
   for (ClassFactory s : EnumSet.allOf(ClassFactory.class))
         lookup.put(s.getIntValue(), s);
   }

   public static ClassFactory getValue(int intValue) {
      return lookup.get(intValue);
   }

}