import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static Timer timer;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.launchSomeTimer("john doe");

        Thread.sleep(5000);
        main.resetSomeTimer();

        Thread.sleep(10000);
        timer.cancel();


    }

    private void launchSomeTimer(String name) {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("name: " + name);
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 500);

    }

    public void resetSomeTimer() {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("updating timer");
            }
        };
        timer.cancel();
        timer = new Timer();
        timer.schedule(timerTask, 1000);

    }
}