// First initialize latch with your number of threads
 CountDownLatch latch = new CountDownLatch(N);

 // Then give this instance of latch to each of your threads

 // and finally at your checkpoint do
 latch.countDown();
 latch.await();