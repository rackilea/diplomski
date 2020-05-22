import java.util.concurrent.Future;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FutureResultProcessor extends Thread {

    private final ConcurrentLinkedQueue<Future<MyWorkerResult>> resultQueue = new ConcurrentLinkedQueue<Future<MyWorkerResult>>();
    private final Integer CHECK_SLEEP = 300;

    public FutureResultProcessor() {
    }

    public void run() {
        while(true) {
            Future<MyWorkerResult> myFuture = resultQueue.poll();

            if(myFuture == null) {
                // There's nothing to process
                try { Thread.sleep(CHECK_SLEEP); } catch (InterruptedException e) {}
                continue;
            }

            // Process result
            if(myFuture != null) {

                MyFutureResult myFutureResult = myFuture.get();

                // Process result
            }
        }
    }

    public void add(Future<MyWorkerResult> sqsFuture) {
        resultQueue.offer(sqsFuture);
    }
}