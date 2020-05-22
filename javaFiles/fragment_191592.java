import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private List<BlockingQueue<Integer>> blockingQueues = new ArrayList<>();
    private List<Integer> fullPartitions;
    private List<Integer> activePartitions;
    long timer = System.currentTimeMillis();
    int THRESHOLD = 10000;
    int currentQueue = 0;

    public Producer(List<BlockingQueue<Integer>> blockingQueues, List<Integer> fullPartitions, List<Integer> activePartitions) {
        this.blockingQueues = blockingQueues;
        this.fullPartitions = fullPartitions;
        this.activePartitions = activePartitions;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while(true) {
            blockingQueues.get(getNextID()).offer(new Random().nextInt(100000));
            try {
                if(System.currentTimeMillis()-start<300000)
                    Thread.sleep(1);
                else
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getNextID() {
        if(System.currentTimeMillis()-timer>30000) {
            activePartitions = new ArrayList<>();
            long mean = 0l; 
            for(int i=0;i<fullPartitions.size();i++) 
                mean += blockingQueues.get(i).size();

            mean  = mean/blockingQueues.size();
            for(int i=0;i<fullPartitions.size();i++) 
                if(blockingQueues.get(i).size()-mean<THRESHOLD)
                    activePartitions.add(i);

            timer = System.currentTimeMillis();
        }
        int partitionID = activePartitions.get(currentQueue%activePartitions.size());
        currentQueue++;
        return partitionID;
    }
}