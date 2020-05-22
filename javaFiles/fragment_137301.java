public class CounterTest {
   private static int counter1 = 0;
   private static int counter2 = 0;

   public static void incrCounter1ViaParameter(int counter) {
      counter++;  // increments the **parameter** 
   }

   public static void incrCounter2Directly() {
      counter2++; // directly increments the **static class field**
   }

   public static void main(String[] args) {
      for (int i = 0; i < 10; i++) {
         incrCounter1ViaParameter(counter1);
         incrCounter2Directly();
      }

      System.out.println("Counter 1: " + counter1);
      System.out.println("Counter 2: " + counter2);

   }
}