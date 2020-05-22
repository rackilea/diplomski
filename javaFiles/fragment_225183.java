import java.util.Calendar;
import java.util.Date;

public class Dates {
    public static void main(final String[] args)
    {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 15);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.YEAR, 2005);
        cal.set(Calendar.HOUR, 17);
        cal.set(Calendar.MINUTE, 35);
        cal.set(Calendar.SECOND, 20);
        final Date date = cal.getTime();

        System.out.printf("Date %s is encoded as: %s\n", date, Long.toHexString(date.getTime()));
        // decode with: new Date(Long.parseLong("1082f469308", 16))
    }
}