import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestCalendar
{

    public static void main( String[] args )
    {
        Locale locale = Locale.getDefault();
        Calendar c = Calendar.getInstance();
        c.setTime( new Date( new Long( 1293840000000l ) ) );  // First moment of the year 2011 in UTC.
        System.out.println( "Locale: " + locale + " | FirstDayOfWeek: " + c.getFirstDayOfWeek() + " | MinimialDaysInFirstWeek: " + c.getMinimalDaysInFirstWeek() );
    }
}