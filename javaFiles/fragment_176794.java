import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {

    private static Timer timer = new Timer();

    private static Calendar getFirstTime() {
        Calendar cal = Calendar.getInstance();

        int currentMinute = cal.get(Calendar.MINUTE);

        if (currentMinute < 45) {
            cal.set(Calendar.MINUTE, 45);
        }
        if (currentMinute < 30) {
            cal.set(Calendar.MINUTE, 30);
        }
        if (currentMinute < 15) {
            cal.set(Calendar.MINUTE, 15);
        }
        if (currentMinute >= 45) {
            cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
            cal.set(Calendar.MINUTE, 0);
        }

        cal.set(Calendar.SECOND, 0);

        return cal;
    }

    public static void main(String... args) {
        Calendar firstTaskTime = getFirstTime();
        System.out.println("Task will start at: " + firstTaskTime.getTime());
        timer.schedule(new MyTask(), firstTaskTime.getTime(), 1000 * 60 * 15);
    }
}

class MyTask extends TimerTask {
    public void run() {
        System.out.println("running task");
    }
}