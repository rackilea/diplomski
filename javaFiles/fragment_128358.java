class Resource implements Callable<String> { 
    private final CountDownLatch latch;
    public Resource(CountDownLatch latch) { this.latch = latch; }
    public String call() throws Exception {
        latch.await();
        return getData();
    }
}