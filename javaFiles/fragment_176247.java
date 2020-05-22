public class TestThread {

    public static void main(final String[] arguments) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            executor.submit(new Task());
            System.out.println("Shutdown executor"); // 1
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("tasks interrupted"); // not invoked because caught in Task.run()
        } finally {

            if (!executor.isTerminated()) {
                System.out.println("cancel non-finished tasks"); // 3
            }
            executor.shutdownNow();
            System.out.println("shutdown finished"); // 4
        }
    }

    static class Task implements Runnable {

        public void run() {

            try {
                int duration = 6;
                System.out.println("Running Task!");  // 2
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}