import org.joda.time.*;
import org.joda.time.chrono.*;

public class Test   
{
    public static void main(String[] args)
    {        
        System.out.println(getDaysInMonth(2009, 2));
    }

    public static int getDaysInMonth(int year, int month)
    {
        // If you want to use a different calendar system (e.g. Coptic)
        // this is the code to change.
        Chronology chrono = ISOChronology.getInstance();
        DateTimeField dayField = chrono.dayOfMonth();        
        LocalDate monthDate = new LocalDate(year, month, 1);
        return dayField.getMaximumValue(monthDate);
    }
}