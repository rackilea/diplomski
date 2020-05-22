package snippet;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static Timer timer;

    public static void main(String[] args) {
        Main main = new Main();
        main.myTimer(123, "127.0.0.1");


    }

    public void myTimer(final long MAC, final String ipAddress) {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("MAC: " + MAC + "ipAddress:" + ipAddress);
                update();
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 1000);

    }

    public void update() {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Updated timer");

            }
        };
        timer.cancel();
        timer = new Timer();
        timer.schedule(timerTask, 2000);
    }
}