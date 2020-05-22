import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class KafkaLoadBalancer {

    private static int MAX_PARTITION = 4;

    public static void main(String args[]) throws InterruptedException {
        List<BlockingQueue<Integer>> blockingQueues = new ArrayList<>();
        List<Integer> fullPartitions = new ArrayList<Integer>();
        List<Integer> activePartitions = new ArrayList<Integer>();

        System.out.println("Creating Queues");
        for(int i=0;i<MAX_PARTITION;i++) {
            blockingQueues.add(new ArrayBlockingQueue<>(1000000));
            fullPartitions.add(i);
            activePartitions.add(i);
        }

        System.out.println("Starting Producers");
        for(int i=0;i<MAX_PARTITION;i++) {
            Producer producer = new Producer(blockingQueues,fullPartitions,activePartitions);
            new Thread(producer).start();
        }

        System.out.println("Starting Consumers");
        for(int i=0;i<MAX_PARTITION;i++) {
            Consumer consumer = new Consumer(blockingQueues.get(i),i+1,i);
            new Thread(consumer).start();
        }

        System.out.println("Starting Display Thread");
        DisplayQueue dq = new DisplayQueue(blockingQueues);
        new Thread(dq).start();
    }
}