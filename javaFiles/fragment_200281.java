package stackOv;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class UseBarrier {

  public static void main(String[] args) throws Exception {
    int numThreads = 2 ;
    // one slot for the coordinator
    CyclicBarrier barrierStart = new CyclicBarrier(numThreads+1);
    CyclicBarrier barrierEnd = new CyclicBarrier(numThreads+1);

    Runnable work1 = new WorkerThread(barrierStart, barrierEnd, "work-0");
    Runnable work2 = new WorkerThread(barrierStart, barrierEnd, "work-1");
    new Thread(work1).start();
    new Thread(work2).start();

    while (true) {
      System.out.println("main: start");
      Thread.sleep(1000);
      barrierStart.await();
      System.out.println("waiting for workers..");
      barrierEnd.await();
      System.out.println("work finished, continue");
      Thread.sleep(1000);
    }
  }
}

class WorkerThread implements Runnable {
  private CyclicBarrier startWork;
  private CyclicBarrier endWork;
  private String name;
  public WorkerThread(CyclicBarrier startWork, CyclicBarrier barrier, String name) {
    this.startWork = startWork;
    this.endWork = barrier;
    this.name = name;
  }

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("worker "+name+": waiting");
        startWork.await();
        System.out.println("working.. "+name);
        Thread.sleep(1000);
        System.out.println("worker "+name+": done");
        endWork.await();
      } catch (BrokenBarrierException | InterruptedException e) {
        // depending on your application, you can either manage the
        // brokenBarrier exception, close your program (or ignore it)
      }
    }
  }
}