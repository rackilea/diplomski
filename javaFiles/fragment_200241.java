public class AlphavantageStockRequestDispatcherTest {

    @Test
    void startDispatcher_TwoFullCycles_WithOneHourIntervalBetween() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        AlphavantageStockRequestDispatcher.startAlphavantageStockScraper(1, latch);
        latch.await(20, TimeUnit.SECONDS);
        System.out.println("first finished - need some assertions");
    }

}