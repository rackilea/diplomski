CountDownLatch countDownLatch = new CountDownLatch(10);
 countDownLatch.await(1000, TimeUnit.MILLISECONDS);
 int queueSize = queue.size();
 for(int i = 0; i < queueSize; ++i) {
     ... do your work here or put in a batch a do it right after loop
 }