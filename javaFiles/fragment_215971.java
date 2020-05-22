import java.util.concurrent.*;
public class RecursiveTotalFinder {
    public static void main(String... args) throws InterruptedException {
       SynchronousQueue<Integer> syncQueue = new SynchronousQueue<>();

       //Create object
       TotalFinder tf = new TotalFinder(syncQueue, 5);

       //Start the thread
       tf.start();

       for (int i = 0; i < 3; ++i) {
         System.out.println("Current total: " + syncQueue.take());
       }
    }
}

class TotalFinder extends Thread{
  private final SynchronousQueue<Integer> syncQueue;
  private final int syncEvery;
  private int count;

  public TotalFinder(SynchronousQueue<Integer> syncQueue, 
                     int syncEvery) {
    this.syncQueue = syncQueue;
    this.syncEvery = syncEvery;
  }

  public void run() {
    try {
      findTotal(16);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }

  //Find total
  void findTotal(int cnt) throws InterruptedException {
    if((count > 0) && (count%syncEvery==0)) {
      syncQueue.put(count);
    }
    count +=1;
    if(count < cnt) {
      System.out.println(count +" < "+cnt);
      findTotal(cnt);
    }
  }
}