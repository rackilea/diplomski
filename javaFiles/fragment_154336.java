import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TheadTest {

    private ExecutorService executor = Executors.newFixedThreadPool(50);

    public void startTenThreads() {
        for (int i = 0; i < 10; i++) {
            executor.execute(new FooWorker(i));
        }
    }

    private final class FooWorker implements Runnable {
        private int threadNum;

        public FooWorker(int threadNum) {
            this.threadNum = threadNum;
        }

        public void run() {
            try {
                System.out.println("Thread " + threadNum + " starting");
                Thread.sleep(60000);
                System.out.println("Thread " + threadNum + " finished");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TheadTest tt = new TheadTest();
        tt.startTenThreads();
    }

}