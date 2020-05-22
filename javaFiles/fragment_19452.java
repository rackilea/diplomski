package snippet;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadWriter implements Runnable {
    private SyncWriter sw;

    public MultiThreadWriter(SyncWriter sw) {
        this.sw = sw;
    }

    public void run() {
        // ...
        sw.println("whatever");
        // ....
    }

    public static void main(String[] args) {
        SyncWriter writer = null;
        try {
            writer = new SyncWriter("foo.csv");
            ExecutorService pool = Executors.newFixedThreadPool(10);
            pool.submit(new MultiThreadWriter(writer));
            pool.submit(new MultiThreadWriter(writer));
            pool.submit(new MultiThreadWriter(writer));
            pool.submit(new MultiThreadWriter(writer));
            pool.submit(new MultiThreadWriter(writer));
            pool.submit(new MultiThreadWriter(writer));
            pool.submit(new MultiThreadWriter(writer));
            pool.shutdown();
            while (pool.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                ;
            }
            writer.close();
        } catch (Exception e) {
            // ..
        }
    }
}

class SyncWriter {
    private PrintWriter pw;

    public SyncWriter(String path) throws FileNotFoundException {
        pw = new PrintWriter(path);
    }

    public void close() {
        pw.close();
    }

    public synchronized void println(String x) {
        pw.println(x);
    }
}