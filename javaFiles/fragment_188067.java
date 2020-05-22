import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleTaskExecutor {

public static void main(String[] args) {

    try {
        new SingleTaskExecutor().runTest();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void runTest() throws Exception {

    ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

    tp.setRejectedExecutionHandler(new RejectedTaskHandler());

    final Semaphore oneTaskDone = new Semaphore(0);
    tp.execute(new Runnable() {
        @Override public void run() { 
            System.out.println("Sleeping");
            try { Thread.sleep(300); } catch (Exception e) { e.printStackTrace();} 
            System.out.println("Done sleeping");
            oneTaskDone.release();
        }
    });
    tp.execute(new Runnable() {
        @Override public void run() { System.out.println("Never happends"); }
        @Override public String toString() { return "Rejected Runnable"; }
    });
    oneTaskDone.acquire();
    tp.execute(new Runnable() {
        @Override public void run() { System.out.println("Running"); }
    });
    tp.shutdown();
    tp.awaitTermination(100, TimeUnit.MILLISECONDS);
    System.out.println("Finished");
}

static class RejectedTaskHandler implements RejectedExecutionHandler {

    @Override public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r);
    }

}

}