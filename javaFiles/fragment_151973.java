package com.stackoverflow.q3379797;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        Receiver receiver = new Receiver(barrier);
        Sender sender = new Sender(barrier);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(receiver);
        executor.submit(sender);
    }

}

class Receiver implements Runnable {

    private CyclicBarrier barrier;

    public Receiver(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Wait for ACK (the sleep just simulates that).
                Thread.sleep(2000);
                System.out.println("ACK");

                // Then notify.
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Sender implements Runnable {

    private CyclicBarrier barrier;

    public Sender(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Wait for notify.
                barrier.await();

                // Now do SEND.
                System.out.println("SEND");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}