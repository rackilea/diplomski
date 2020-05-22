import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class MyQueue {
    private int capacity;
    private List<Integer> queue = new LinkedList<>();

    public MyQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(int item) throws InterruptedException {
        while (queue.size() == this.capacity) {
            wait();
        }

        System.out.println("Thread " + Thread.currentThread().getName() +
                           " producing " + item);
        queue.add(item);

        if (queue.size() == 1) {
            notifyAll();
        }
    }

    public synchronized int dequeue() throws InterruptedException {
        int item;

        while (queue.size() == 0) {
            wait();
        }

        item = queue.remove(0);

        System.out.println("Thread " + Thread.currentThread().getName() +
                           " consuming " + item);

        if (queue.size() == (capacity - 1)) {
            notifyAll();
        }

        return item;
    }
}

public class ProducerConsumer {
    private static class Producer implements Runnable {
        private MyQueue queue;
        private Random random = new Random();

        public Producer(MyQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                for (;;) {
                    queue.enqueue(random.nextInt());
                    Thread.sleep((int)(Math.random() * 3000) + 1000);
                }
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() +
                        " interrupted");
            }
        }
    }

    private static class Consumer implements Runnable {
        private MyQueue queue;

        public Consumer(MyQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                for (;;) {
                    queue.dequeue();
                    Thread.sleep((int)(Math.random() * 5000) + 3000);
                }
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() +
                        " interrupted");
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);

        new Thread(new Producer(queue), "Producer 1").start();
        new Thread(new Producer(queue), "Producer 2").start();
        new Thread(new Consumer(queue), "Consumer 1").start();
        new Thread(new Consumer(queue), "Consumer 2").start();
    }
}