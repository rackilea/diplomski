import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Timer {
    protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    protected static final TimeUnit UNIT = TimeUnit.NANOSECONDS;
    private final long initialTime;

    private static final long NANOSECONDS_IN_DAY = TimeUnit.DAYS.toNanos(1);
    private static final long NANOSECONDS_IN_HOUR = TimeUnit.HOURS.toNanos(1);
    private static final long NANOSECONDS_IN_MINUTE = TimeUnit.MINUTES.toNanos(1);

    public Timer() {
        initialTime = System.nanoTime();
    }

    public long elapsedTime() {
        return System.nanoTime() - initialTime;
    }

    public String toString() {
        return formatTime(elapsedTime(), UNIT, DATE_FORMAT);
    }

    private static final int nanosecondsToHours(long nanoseconds) {
        return (int) UNIT.toHours(nanoseconds % NANOSECONDS_IN_DAY);
    }

    private static final int nanosecondsToMinutes(long nanoseconds) {
        return (int) UNIT.toMinutes(nanoseconds % NANOSECONDS_IN_HOUR);
    }

    private static final int nanosecondsToSeconds(long nanoseconds) {
        return (int) UNIT.toSeconds(nanoseconds % NANOSECONDS_IN_MINUTE);
    }

    public static String formatTime(long timestamp, TimeUnit unit, DateFormat dateFormat) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, nanosecondsToHours(timestamp));
        cal.set(Calendar.MINUTE, nanosecondsToMinutes(timestamp));
        cal.set(Calendar.SECOND, nanosecondsToSeconds(timestamp));

        return dateFormat.format(cal.getTime());
    }
}