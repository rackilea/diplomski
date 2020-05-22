public class CounterClass {
   private volatile int counter;

   public int increment() {
       return counter++;
   }
}