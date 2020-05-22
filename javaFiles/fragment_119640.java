import java.util.concurrent.atomic.AtomicInteger;

public class DataRace implements Runnable {
    static volatile AtomicInteger x = new AtomicInteger(0);

    public void run() {
        for (int i = 0; i < 10000; i++) {
            x.incrementAndGet();
            x.decrementAndGet();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++)
            threads[i] = new Thread(new DataRace());
        for (int i = 0; i < threads.length; i++)
            threads[i].start();
        for (int i = 0; i < threads.length; i++)
            threads[i].join();

        System.out.println(x); // x **is now** always 0!
    }
}