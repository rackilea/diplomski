public class ResultFuture {

    private volatile Result result = null;
    private final CountDownLatch latch = new CountDownLatch(1);

    public Result get() throws InterruptedException {
        latch.await();
        return result;
    }

    public void set(Result result) {
        this.result = result;
        latch.countDown();
    }
}