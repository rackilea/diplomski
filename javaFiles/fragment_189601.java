public class Consumer {

   private boolean shuttingDown = false;

   public void shutdown() {
     shuttingDown = true;
   }

   public void run() {
     if (!list.isEmpty() && !shuttingDown) {
        // pull item and process
     }
   }
}