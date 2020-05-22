class MockCallback implements Callback {
   private final CountDownLatch latch;
   String res;

   public MockCallback(CountDownLatch latch) { this.latch = latch; }

   public void done(String res) {
      this.res = res;
      latch.countDown();
   }
}