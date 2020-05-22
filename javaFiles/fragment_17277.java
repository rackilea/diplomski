public class MyLongRunningTask implements Runnable
{
   private volatile boolean cancelled;

   public void run() {
      while (!cancelled) {
         System.out.println("Do something...");
      }
   }

   public void setCancelled(boolean cancelled) {
      this.cancelled = cancelled;
   }
}