import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Dates {

    public static void main(String[] args) throws Exception {
        try {
            AtomicInteger excCounter = new AtomicInteger(0);
            CompletableFuture one = CompletableFuture.runAsync(new ExcRunnable(excCounter));
            CompletableFuture two = CompletableFuture.runAsync(new PrintRunnable("2", excCounter));
            CompletableFuture three = CompletableFuture.runAsync(new PrintRunnable("3", excCounter));
            CompletableFuture all = CompletableFuture.allOf(one, two, three);
            all.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    }
}

class ExcRunnable implements Runnable {
    private final AtomicInteger excCounter;

    public ExcRunnable(AtomicInteger excCounter) {
        this.excCounter = excCounter;
    }

    @Override
    public void run() {
        Random random = new Random();
        int millis = (int) (random.nextDouble() * 5000);
        System.out.println("Wait " + millis);
        Threads.sleep(450);

        // Inform another threads that exc occurred
        excCounter.incrementAndGet();

        throw new RuntimeException("error");
    }
}

class PrintRunnable implements Runnable {

    private final String name;
    private final AtomicInteger excCounter;

    public PrintRunnable(String name, AtomicInteger excCounter) {
        this.name = name;
        this.excCounter = excCounter;
    }

    @Override
    public void run() {
        int counter = 10;
        while (counter-- > 0 && excCounter.get() == 0) {
            System.out.println(name);
            Threads.sleep(450);
        }
    }
}

class Threads {
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}