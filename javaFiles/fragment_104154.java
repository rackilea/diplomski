package com.mytest.example;

public class ThreadDemo {

    int message;
    String threadName;
    boolean consumed;

    ThreadDemo(int message, String threadName, boolean consumed) {
        this.setMessage(message);
        this.setThreadName(threadName);
        this.setConsumed(consumed);
    }

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo(0,"Main",true);

        Thread producer = new Thread(new Producer(demo));
        Thread consumer = new Thread(new Consumer(demo));

        producer.start();
        consumer.start();

        try {
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println("ERROR:- "+e.getMessage());
        }
        System.out.println("Main() exit");
    }

    /**
     * @return the message
     */
    public int getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(int message) {
        this.message = message;
    }

    /**
     * @return the threadName
     */
    public String getThreadName() {
        return threadName;
    }

    /**
     * @param threadName the threadName to set
     */
    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    /**
     * @return the contentAvailable
     */
    public boolean isConsumed() {
        return consumed;
    }

    /**
     * @param contentAvailable the contentAvailable to set
     */
    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }
}

class Producer implements Runnable {

    ThreadDemo demo;

    Producer(ThreadDemo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++) {
            produce(i);
        }
    }

    /**
     * This method is used to produce a value in demo object & block the other threads which are waiting for demo object.
     * Once the producer finishes its task, it notifies all other waiting threads & releases the lock on demo object.
     * @param value
     */
    public void produce(int value) {
        synchronized (demo) {
            try {
                while(!demo.isConsumed()) {
                    demo.wait();
                }
                if(demo.isConsumed()) {
                    demo.setMessage(value);
                    demo.setThreadName("Producer");
                    demo.setConsumed(false);
                    System.out.println(demo.getThreadName()+": "+demo.getMessage());
                    Thread.sleep(1000);
                    demo.notifyAll();
                }
            } catch(InterruptedException e) {
                System.out.println("ERROR:- "+e.getMessage());
            }
        }
    }
}

class Consumer implements Runnable {

    ThreadDemo demo;

    Consumer(ThreadDemo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        for(int i=1; i<=10;i++) {
            consume();
        }
    }

    /**
     * This method checks whether any content available to consume from producer. If yes then it will acquire the lock 
     * on demo object and consumes the content. Once the content is consumed, it will releases the lock on demo object.
     */
    public void consume() {
        synchronized (demo) {
            try {
                while(demo.isConsumed()) {
                    demo.wait();
                }
                if(!demo.isConsumed()) {
                    demo.setThreadName("Consumer");
                    demo.setConsumed(true);
                    System.out.println(demo.getThreadName()+": "+demo.getMessage());
                    Thread.sleep(1000);
                    demo.notifyAll();
                }
            } catch(InterruptedException e) {
                System.out.println("ERROR:- "+e.getMessage());
            }
        }
    }
}