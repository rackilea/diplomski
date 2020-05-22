import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(100000000);
    private int delayFactor;
    public Consumer(BlockingQueue<Integer> blockingQueue, int delayFactor, int consumerNo) {
        this.blockingQueue = blockingQueue;
        this.delayFactor = delayFactor;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while(true) {
            try {
                blockingQueue.take();
                if(blockingQueue.isEmpty())
                    System.out.println((System.currentTimeMillis()-start)/1000);
                Thread.sleep(delayFactor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}