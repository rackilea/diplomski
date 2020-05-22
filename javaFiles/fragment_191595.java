import java.util.List;
import java.util.concurrent.BlockingQueue;

public class DisplayQueue implements Runnable {

    private List<BlockingQueue<Integer>> blockingQueues;

    public DisplayQueue(List<BlockingQueue<Integer>> blockingQueues) {
        this.blockingQueues = blockingQueues;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        while(true) {
            if(System.currentTimeMillis()-start>30000) {
                for(int i=0;i<blockingQueues.size();i++)
                    System.out.println("Queue "+i+" size is=="+blockingQueues.get(i).size());
                start = System.currentTimeMillis();
            }
        }

    }

}