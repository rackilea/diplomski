public class CountDownBarrierTest {
    public static final Logger LOG = LogManager.getLogger(CountDownBarrierTest.class);
    public static int ITER = 5;

    @Test
    public void test1() throws InterruptedException {
        LOG.info("CountDownBarrierTest.test1()");
        CountDownBarrier barrier = new CountDownBarrier(4, 5000);

        List<Thread> tList = new ArrayList<Thread>();
        for(int i = 0; i < 3; i++) {
            TheAction x = new TheAction(i, barrier);
            tList.add(new Thread(x));
        }

        LOG.info("Start all threads");
        for(Thread t : tList) {
            t.start();
        }

        for(Thread t : tList) {
            t.join();
        }
        LOG.info("All threads finished");
    }

    private class TheAction
    implements Runnable {       
        private int id;
        private CountDownBarrier barrier;

        public TheAction(int id, CountDownBarrier barrier) {
            this.id = id;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                for(int i = 0; i < ITER; i++) {
                    barrier.acquire();
                    LOG.info("#" + id + ": Action!!");
                    Thread.sleep(1000);
                    //LOG.info("#" + id + ": ------------");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}