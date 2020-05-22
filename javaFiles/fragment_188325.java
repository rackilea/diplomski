package stackOv;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyQueueWorker implements Runnable {
    private BlockingQueue<Object> q;
    MyQueueWorker(BlockingQueue<Object> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object item = q.take();
                // work here
                System.out.println("obj=" + item);
            } catch (InterruptedException e) {
                System.out.println("worker thread is interrupted");
                break;
            }
        }
        System.out.println("interrupted, exiting worker thread");
    }
}

public class InterruptTake {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Object> q = new LinkedBlockingQueue<>();
        Thread worker = new Thread( new MyQueueWorker(q ), "worker" );
        worker.start();
        q.put("hello");
        q.put("world");
        q.put("waiting..");
        Thread.sleep(1000);
        worker.interrupt();
    }
}