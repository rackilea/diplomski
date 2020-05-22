public class MySwingWorker extends SwingWorker {

   private final Runnable r;
   public MySwingWorker(Runnable r) {
       this.r = r;
   }
   public void doInBackground() {...}
   public void done() { r.run(); }
 }