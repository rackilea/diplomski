import java.util.*;
import java.util.concurrent.*;
import java.text.*;

public class Test {    
    public static void main(String args[]) throws ParseException {
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date start = format.parse("05:00");
        Date end = format.parse("15:20");

        long difference = end.getTime() - start.getTime();

        long hours = TimeUnit.MILLISECONDS.toHours(difference);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(difference) % 60;

        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
    }
}