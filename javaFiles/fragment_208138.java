import java.util.concurrent.TimeUnit;

public class ThreadTimer implements Runnable {

    public static void main(String[] args) {

        ThreadTimer tt = new ThreadTimer();
        long afterStart = 0L;
        new Thread(tt).start();
        afterStart = System.nanoTime();
        println("After start: " + afterStart);
        try {
            Thread.sleep(100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long deltaStart = tt.realStart - afterStart;
        println("Delta start: " + deltaStart);
        long deltaStartMs = TimeUnit.NANOSECONDS.toMillis(deltaStart);
        println("Delta start ms.: " + deltaStartMs);
    }

    public long realStart;

    @Override
    public void run() {

        realStart = System.nanoTime();
        println("Real start : " + realStart);
    }
    private static void println(String msg) {
        System.out.println(msg);
    }

}