import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {

    protected List<Integer> buffer = new ArrayList<Integer>();

    // the lock on which condition variables are taken
    protected volatile Lock lock = new ReentrantLock(true);
    // the consumer will signal using this condition variable to the producer to
    // start it's production
    protected volatile Condition producerStartProducing = lock.newCondition();
    // the producer will use this condition variable to start it's production
    protected volatile Condition consumerStartConsuming = lock.newCondition();

    class Consumer implements Callable<String> {

        int num;

        public Consumer(int i) {
            this.num = i;
        }

        /**
         * In a loop, take a lock each time, check if there is an item to
         * consume from shared buffer If yes, then consume it and loop back If
         * no, then wait for the producer to signal you. Signals the producer
         * each time it consumes an item.
         */
        @Override
        public String call() throws Exception {

            int i = 0;
            while (i < 10) {
                try {
                    lock.lock();
                    while (buffer.isEmpty()) {
                        consumerStartConsuming.await();
                    }

                    System.out.println("Consumer - " + i);
                    buffer.remove(buffer.size() - 1);
                    producerStartProducing.signalAll();
                    i++;
                } finally {
                    lock.unlock();
                }
            }

            System.out.println("Consumed All");
            return "Consumed All";

        }

    }

    class Producer implements Callable<String> {

        int num;

        public Producer(int i) {
            this.num = i;
        }

        /**
         * In a loop, take a lock, produce items in a batch of 3, and then wait
         * till the consumer signals you to produce more. Signals the consumer
         * each time it produces an item
         */
        @Override
        public String call() throws Exception {

            int i = 0;
            while (i < 10) {
                try {
                    lock.lock();
                    while (buffer.size() > 2) {
                        producerStartProducing.await();
                    }
                    System.out.println("Producer - " + i);
                    buffer.add(1);
                    consumerStartConsuming.signalAll();
                    i++;
                } finally {
                    lock.unlock();
                }
            }

            System.out.println("Produced All");
            return "Produced All";
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
        try {
            ProducerConsumerImpl producerConsumerImpl = new ProducerConsumerImpl();
            Future<String> p1 = newFixedThreadPool.submit(producerConsumerImpl.new Producer(1));
            Future<String> c1 = newFixedThreadPool.submit(producerConsumerImpl.new Consumer(1));
            final String string1 = p1.get();
            final String string2 = c1.get();
            System.out.println(string1 + " --- " + string2);
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

}