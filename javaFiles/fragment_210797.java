CyclicBarrier cb = new CyclicBarrier(3);
new Thread(new Thread1(cb)).start();
new Thread(new Thread2(cb)).start();
new Thread(new Thread3(cb)).start();

class Thread1 implements Runnable() {
   private CyclicBarrier barrier;
   public Thread1(CyclicBarrier cb) {
      barrier = cb;
   }

   public void run() {
       // execute 1A
       barrier.await();
       // execute 1B
}

class Thread2 implements Runnable() {
   private CyclicBarrier barrier;
   public Thread2(CyclicBarrier cb) {
      barrier = cb;
   }

   public void run() {
       // execute 2A
       barrier.await();
       // execute 2B
}

// repeat for Thread3