public class AsyncDatabaseWriter implements Runnable {
     private LinkedBlockingQueue<Data> queue = ....
     private volatile boolean terminate = false;
     public void run() {
         while(!terminate) {
            Data data = queue.take();
            // write to database
         }
     }
     public void ScheduleWrite(Data data) {
         queue.add(data);
     }
 }