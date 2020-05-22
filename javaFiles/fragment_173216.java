import java.util.concurrent.*;

public class MyClass {
    static Producer p;
    static Consumer c;

    public static void main(String[] args) {
        BlockingQueue q = new LinkedBlockingQueue();
        p = new Producer();
        c = new Consumer();
        Thread t = new Thread(p);
        t.start();
        new Thread(c).start();
        while (true) {
            if (!p.getContinuer()) {
                c.setContinuer(false);
                break;
            }
        }
        System.out.println("finish all");
    }
}

class Producer implements Runnable {
    private boolean end = true;
    private BlockingQueue queue;
    private AtomicBoolean continuer = new AtomicBoolean(true);

    public boolean getContinuer() {
        return continuer.get();
    }

    @Override
    public void run() {
        while (true) {
            // open socket
            // read data from socket
            if (end) {
                System.out.println("Shutting down Producer");
                continuer.getAndSet(false);
                break;
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue queue;
    private static AtomicBoolean continuer = new AtomicBoolean(true);

    public void setContinuer(Boolean continuerr) {
        continuer = new AtomicBoolean(continuerr);
    }

    public Boolean getContinuer() {
        return continuer.get();
    }

    @Override
    public void run() {
        while (getContinuer()) {
            // Do some work
        }
        System.out.println("shut down Consumer");
    }
}