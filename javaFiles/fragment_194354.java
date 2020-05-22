class Service {
   private final Object calc1Lock = new Object();
   private final Object calc2Lock = new Object();

   public void calc1() {
       synchronized(calc1Lock) {
           // ... method body
       }
   }

   public void calc2() {
       synchronized(calc2Lock) {
           // ... method body
       }
   }

}