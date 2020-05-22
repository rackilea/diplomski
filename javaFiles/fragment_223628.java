package com.stackoverflow.q2755338;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String... args) throws Exception {
        // Those are indeed called sequentially.
        System.out.println("Starting to fire 3 requests in current thread...");
        new TestURL().run();
        new TestURL().run();
        new TestURL().run();
        System.out.println("Finished firing 3 requests in current thread!");

        // But those are called three at once.
        System.out.println("Starting to fire 3 requests in each its own thread...");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new TestURL());
        executor.submit(new TestURL());
        executor.submit(new TestURL());
        System.out.println("Finished firing 3 requests in each its own thread!");
        executor.shutdown();
    }

}

class TestURL implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Firing request...");
            new URL("http://localhost:8181/JavaEE6/test").openStream();
            System.out.println("Request finished!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}