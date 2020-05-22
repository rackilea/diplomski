import java.security.SecureRandom;
import java.util.concurrent.*;

/**
 * Created by Leon.H on 2016/1/13.
 */
public class ProducerConsumer {
    private int producerNumber = 0;
    private int consumerNumber = 0;
    private int bufferSize = 0;
    private final int seconds;

    public ProducerConsumer(int producerNumber, int consumerNumber, int bufferSize, int seconds) {
        this.producerNumber = producerNumber;
        this.consumerNumber = consumerNumber;
        this.bufferSize = bufferSize;
        this.seconds = seconds;
        System.out.println(this.producerNumber+ ": the number of producer threads");
        System.out.println(this.consumerNumber+ ": the number of consumer threads");
        System.out.println(this.bufferSize+ ": the number of producer threads");
    }

    public void process() throws InterruptedException {
        ExecutorService producerExecutorService = Executors.newFixedThreadPool(this.producerNumber);
        ExecutorService consumerExecutorService = Executors.newFixedThreadPool(this.consumerNumber);
        BlockingQueue<Integer> integers = new ArrayBlockingQueue<Integer>(this.bufferSize);

        for (int i = 0; i < this.producerNumber; i++) {
            producerExecutorService.execute(new ProducerTask(integers));
        }

        for (int i = 0; i < this.consumerNumber; i++) {
            consumerExecutorService.execute(new ConsumerTask(integers));
        }

        producerExecutorService.shutdown();
        consumerExecutorService.shutdown();

        //let the program run 10 seconds
        producerExecutorService.awaitTermination(this.seconds, TimeUnit.SECONDS);
        consumerExecutorService.awaitTermination(this.seconds, TimeUnit.SECONDS);
    }

    private class ProducerTask implements Runnable {
        private final BlockingQueue<Integer> integers;

        public ProducerTask(BlockingQueue<Integer> integers) {
            this.integers = integers;
        }

        public void run() {
            while (true) {
                Integer content = new SecureRandom().nextInt(1000);
                System.out.println("Producer #" + Thread.currentThread().getId() + " put: " + content);
                integers.offer(content);
                try {
                    Thread.sleep(new SecureRandom().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ConsumerTask implements Runnable {
        private final BlockingQueue<Integer> integers;

        public ConsumerTask(BlockingQueue<Integer> integers) {
            this.integers = integers;
        }

        public void run() {
            while (true) {
                try {
                    System.out.println("Consumer #" + Thread.currentThread().getId() + " get: " + integers.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(new SecureRandom().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

import org.junit.Test;

/**
 * Created by Leon.H on 2016/1/13.
 */
public class ProducerConsumerTest {
    @Test
    public void oneProducerOneConsumerSizeOne() throws InterruptedException {
        int ProducerNumber = 1;
        int ConsumerNumber = 1;
        int size = 1;
        int seconds=5;
        ProducerConsumer producerConsumer = new ProducerConsumer(ProducerNumber, ConsumerNumber, size, seconds);
        producerConsumer.process();
    }

    @Test
    public void twoProducerThreeConsumerSizeThree() throws InterruptedException {
        int ProducerNumber = 2;
        int ConsumerNumber = 3;
        int size = 3;
        int seconds = 5;
        ProducerConsumer producerConsumer = new ProducerConsumer(ProducerNumber, ConsumerNumber, size, seconds);
        producerConsumer.process();
    }

    @Test
    public void twoHundredProducerThreeConsumerSizeThree() throws InterruptedException {
        int ProducerNumber = 20;
        int ConsumerNumber = 3;
        int size = 3;
        int seconds=5;
        ProducerConsumer producerConsumer = new ProducerConsumer(ProducerNumber, ConsumerNumber, size, seconds);
        producerConsumer.process();
    }
}