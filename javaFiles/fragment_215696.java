import java.util.Calendar;
import java.util.GregorianCalendar;

public class EightAm {

    public static void main(String[] args)
    {
        Calendar calendar = GregorianCalendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        for(int i = 0; i < 100; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            System.out.println(calendar.getTime());
        }

    }
}