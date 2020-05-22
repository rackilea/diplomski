import java.util.concurrent.TimeUnit;

public class TimerTest {
    public static void main(String[] args) {
        EnhancedTimer timer = new EnhancedTimer();
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