import java.util.concurrent.TimeUnit;

public class TimerTest {
    public static void main(String[] args) {
        testTime();
        timeLoop();
    }

    private static void testTime() {
        long hours_23      = TimeUnit.HOURS.toNanos(23);
        long mins_55       = TimeUnit.MINUTES.toNanos(55);
        long secs_55       = TimeUnit.SECONDS.toNanos(55);
        long time_23_55_55 = hours_23 + mins_55 + secs_55;

        System.out.println(Timer.formatTime(time_23_55_55, Timer.UNIT, Timer.DATE_FORMAT)); // 23:55:55
    }

    private static void timeLoop() {
        Timer timer = new Timer();
        long sleepDelay = 5000; // Sleep every 5 seconds.

        try {
            while (true) {
                System.out.printf("%s (%d)%n", timer, timer.elapsedTime());
                Thread.sleep(sleepDelay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}