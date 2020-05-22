CountdownLatch latch;

void run(){
   //...
   this.latch = new CountDownLatch(queueOfA.size());
   Thread bThread = new Thread(b);
   bThread.start();
   latch.await();
  //.. catch InterruptedException etc..
}

void notifyDone(A a) {
    this.latch.countDown();
}