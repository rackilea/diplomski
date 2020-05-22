public class Singleton {
   public final static Singleton INSTANCE = new Singleton();
   private Singleton() {
         // Exists only to defeat instantiation.
      }
}