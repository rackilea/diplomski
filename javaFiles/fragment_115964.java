public class NThread {
    public static int baton;
    public static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        baton = 0;
        TestUtil.N = 2;
        runThread();
    }

    protected static void runThread() throws InterruptedException {
        int i;
        Thread b[] = new Thread[TestUtil.N];
        for (i = 0; i < b.length; i++) { // loop limit is on the array length - its clearer like that
            b[i] = new Thread(new ThreadB(i));
            b[i].start();
        }
        TimeUnit.SECONDS.sleep(1);
        for (i = 0; i < b.length; i++) b[i].interrupt();
        for (i = 0; i < b.length; i++) b[i].join();
        System.out.println("All done");
    }
}