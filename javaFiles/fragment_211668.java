public class WorkerThreadFactory implements ThreadFactory {
   private int counter = 0;
   private String prefix = "";

   public WorkerThreadFactory(String prefix) {
     this.prefix = prefix;
   }

   public Thread newThread(Runnable r) {
     return new Thread(r, prefix + "-" + counter++);
   }
}