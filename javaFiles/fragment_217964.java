import java.util.concurrent.CountDownLatch;

public class TestHarness{


    public long timeTask(int nThreads, final Runnable task) throws InterruptedException{

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for(int i = 0; i < nThreads; i++) {
           Thread t = new Thread( new Runnable(){

            @Override
            public void run() {
                  try{
                      System.out.println("Init");
                      startGate.await();

                      try{
                          task.run();
                      } finally {
                          endGate.countDown();
                      }
                  } catch (InterruptedException ignored){ }
               };

            });

           t.start();   // <--- Here
        }
        long start = System.nanoTime();
        startGate.countDown();
        System.out.println("Open Gate");

        endGate.await();
        long end = System.nanoTime();
        return end - start;
 }

    public static void main(String[] args) throws Exception {
        new TestHarness().timeTask(10, new Runnable() {

            @Override
            public void run() {
              System.out.println("Am Running");

            }
        });
    }
}