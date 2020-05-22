public class Reschedule {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Schedule three tasks
        ScheduledFuture future1 = executor.scheduleAtFixedRate(() -> {
            System.out.printf("%03ds: This is the first runnable, reporting in%n", (System.currentTimeMillis() - start) / 1000);
        }, 0, 5, TimeUnit.SECONDS);
        ScheduledFuture future2 = executor.scheduleAtFixedRate(() -> {
            System.out.printf("%03ds: This is the second runnable, reporting in%n", (System.currentTimeMillis() - start) / 1000);
        }, 2, 10, TimeUnit.SECONDS);
        ScheduledFuture future3 = executor.scheduleAtFixedRate(() -> {
            System.out.printf("%03ds: This is the third runnable, reporting in%n", (System.currentTimeMillis() - start) / 1000);
        }, 5, 15, TimeUnit.SECONDS);

        // Wait some
        Thread.sleep(30000);

        // Reschedule the second task
        System.out.printf("%03ds: Rescheduling the second runnable to run at 20 second intervals%n", (System.currentTimeMillis() - start) / 1000);
        future2.cancel(true);
        future2 = executor.scheduleAtFixedRate(() -> {
            System.out.printf("%03ds: This is the second runnable, reporting in%n", (System.currentTimeMillis() - start) / 1000);
        }, 2, 20, TimeUnit.SECONDS);
    }
}