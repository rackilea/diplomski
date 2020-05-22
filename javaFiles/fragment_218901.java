import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblemUsingBlockingQueue {

    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(1);

    public static void main(String[] args) {

        ProducerConsumerProblemUsingBlockingQueue object = new ProducerConsumerProblemUsingBlockingQueue();

        Thread producerThread = new Thread(() -> {
            object.produceData(object.blockingQueue);
        },"Producer");
        Thread consumerThread = new Thread(() -> {
            object.consumeData(object.blockingQueue);
        },"Consumer");
        consumerThread.start();
        producerThread.start();
    }

    private void consumeData(BlockingQueue<Integer> blockingQueue) {
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println("Consumed: "+blockingQueue.take().intValue());
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produceData(BlockingQueue<Integer> blockingQueue) {
        Random randomObject = new Random();
        for(int i = 0; i < 10; i++) {
            try {
                int randomNumber = randomObject.nextInt(100);
                System.out.println("Produced: "+randomNumber);
                blockingQueue.put(randomNumber);
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}