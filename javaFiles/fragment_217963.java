public class TestHarness{

public long timeTask(int nThreads, final Runnable task){

    final CountDownLatch startGate = new CountDownLatch(nThreads);//Changed this from 1
    final CountDownLatch endGate = new CountDownLatch(nThreads);

    for(i = 0; i < nThreads; i++) {
       Thread t = new Thread(){
          try{
              startGate.countDown(); //Reduce the latch count by 1
              startGate.await(); //Once the last Thread is ready, this will continue
              try{
                  task.run();
              } finally {
                  endGate.countDown();
              }
          } catch (InterruptedException ignored){ }
       };
       t.start();   // <--- Here
    }

    long start = System.nanoTime();
    endGate.await();
    long end = System.nanoTime();
    return end - start;
  }

}