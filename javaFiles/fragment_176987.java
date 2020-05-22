public class ThreadLocalFlagTest {

    private static ThreadLocalFlag flag = new ThreadLocalFlag();
    private static boolean runThread = true;

    @AfterClass
    public static void tearDownOnce() throws Exception {
        runThread = false;
        flag = null;
    }

    /**
     * @throws Exception if there is any issue with the test
     */
    @Test
    public void testSetAll() throws Exception {
        startThread("ThreadLocalFlagTest-1", false);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            //ignore
        }
        startThread("ThreadLocalFlagTest-2", true);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            //ignore
        }
        startThread("ThreadLocalFlagTest-3", false);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            //ignore
        }
        startThread("ThreadLocalFlagTest-4", true);
        try {
            Thread.sleep(8000L); //watch the alternating values
        } catch (InterruptedException e) {
            //ignore
        }
        flag.setAll(true);
        try {
            Thread.sleep(8000L); //watch the true values
        } catch (InterruptedException e) {
            //ignore
        }
        flag.setAll(false);
        try {
            Thread.sleep(8000L); //watch the false values
        } catch (InterruptedException e) {
            //ignore
        }
    }

    private void startThread(String name, boolean value) {
        Thread t = new Thread(new RunnableCode(value));
        t.setName(name);
        t.start();
    }

    class RunnableCode implements Runnable {

        private boolean initialValue;

        RunnableCode(boolean value) {
            initialValue = value;
        }

        @Override
        public void run() {
            flag.set(initialValue);
            while (runThread) {
                System.out.println(Thread.currentThread().getName() + ": " + flag.get());
                try {
                    Thread.sleep(4000L);
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        }
    }
}