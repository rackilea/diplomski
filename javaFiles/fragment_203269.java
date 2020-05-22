public void test()
{   
    final CountDownLatch latch = new CountDownLatch(1);
    final int[] value = new int[1];
    Thread uiThread = new HandlerThread("UIHandler"){
        @Override
        public void run(){
            value[0] = 2;
            latch.countDown(); // Release await() in the test thread.
        }
    };
    uiThread.start();
    latch.await(); // Wait for countDown() in the UI thread. Or could uiThread.join();
    // value[0] holds 2 at this point.
}