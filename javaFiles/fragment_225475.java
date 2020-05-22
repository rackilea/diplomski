public class Sync {
    public static int waiting = 0;
    private Object mutex = new Object();

    public void sync() {
        waiting++;
        synchronized (mutex) {
            waiting--;
            long start = System.currentTimeMillis();
            doWhatever();
            System.out.println("duration:"
                    + (System.currentTimeMillis() - start));
        }
    }
}