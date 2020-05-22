public class MyRunnable extends Runnable
{
   private volatile boolean cancelled;

   public void run() {
      while (!cancelled) { 
         doStuff();
      }
   }

   public void cancel()
   {
      cancelled = true;  
   }

   public boolean isCancelled() {
      return cancelled;
   }
}j