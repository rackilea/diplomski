public class AlphavantageStockRequestDispatcher {
    public static void startAlphavantageStockScraper(int timeInterval, CountDownLatch latch) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable getStockList =
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("worker started");
                        try {
                            Thread.sleep(10_000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println("worker finished");
                            Optional.ofNullable(latch).ifPresent(CountDownLatch::countDown);
                        }
                    }
                };

        scheduler.scheduleAtFixedRate(getStockList, 0, timeInterval, TimeUnit.HOURS);

    }

}