public class DataProcessor {
    final BlockingQueue<Data> queue = new BlockingQueue<Data>();

    public void onInit() {
       for (int i = 0; i < n; i++) 
           new Thread(new WorkerRunnable(queue)).start();
    }

    public void onNewDataFromTheOutsideWorld(Data d) { 
       queue.add(d);
    }
}

public class WorkerRunnable implements Runnable {
    public void run() { 
       while (true) {
           Data d = queue.take();
           processData(d);
       }
    }
 }