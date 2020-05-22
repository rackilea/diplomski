import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String... s){
        final CountDownLatch cdl = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 5;
                while(i-- > 0)
                    System.out.println("t2 wait me");
                cdl.countDown();
            }
        });


        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("done");
            }
        });

        t2.start();
        t1.start();
    }

}