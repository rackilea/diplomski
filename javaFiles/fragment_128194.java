public class CountDownLatchTest
{
   public static void main(String[] args) throws InterruptedException {
      CountDownLatch gate = new CountDownLatch( 1 );
      for( int i = 0; i < 3; i++ ) {
         new Thread( new RandomWait( gate, i ) ).start();
      }
      gate.await();
      System.out.println("Done");
   }

   private static class RandomWait implements Runnable
   {
      CountDownLatch gate;
      int num;
      public RandomWait( CountDownLatch gate, int num )
      {
         this.gate = gate;
         this.num = num;
      }

      public void run() {
         try {
            Thread.sleep( (int)(Math.random() * 1000) );
            System.out.println("Thread ready: "+num);
            gate.countDown();
         } catch( InterruptedException ex ) {
         }
      }
   }
}