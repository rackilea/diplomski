package test;

import java.util.LinkedList;
import java.util.List; 
import java.util.concurrent.CountDownLatch;

public class Foo implements Runnable {
    private static final Foo inner = new Foo();
    private final List<String> queue = new LinkedList<String>();
    private final CountDownLatch latch = new CountDownLatch(1);

    private Foo() { }

    public static Foo getInstance() {
        return inner;
    }

    public void addToQueue(String toPrint) {
        synchronized (queue) {
            queue.add(toPrint);
        }
    }

    public void removeFromQueue(String toRemove) {
        synchronized (queue) {
            queue.remove(toRemove);
        }
    }

    public boolean isEmpty() {
        synchronized (queue) {
            return queue.isEmpty();
        }
    }

    public String getHead() {
        synchronized (queue) {
            return queue.get(0);
        }
    }

    public void turnOff() throws InterruptedException {
        latch.await();
        System.out.println("end");
    }

    @Override
    public void run() {
        while (!isEmpty()) {
            String string = getHead();
            System.out.println(string);
            removeFromQueue(string);
        }

        latch.countDown();
    }
}