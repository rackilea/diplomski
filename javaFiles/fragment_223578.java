public class AutoUpdater implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
        for (int i = 0; i < clients.size(); i++) {
            // do something...
        }
        System.out.println("Thread ended.\n");
    }
}

public static class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(
                    new AutoUpdater(clients, lock.writeLock()),
                    0,
                    24,
                    TimeUnit.HOURS);

        System.out.println("This is a test");
    }
}