import java.util.Calendar;
import java.util.Date;

// ... 

public static long getWeekStart()
{
    //INIT Date
    Calendar cal = Calendar.getInstance();
    cal.clear(Calendar.HOUR_OF_DAY);
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);

    //get start of this week in milliseconds
    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    return cal.getTime().getTime();
}

public static long getNextWeek()
{
    //INIT Date
    Calendar cal = Calendar.getInstance();
    cal.clear(Calendar.HOUR_OF_DAY);
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);

    //get start of this week in milliseconds
    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

    // start of the next week
    cal.add(Calendar.WEEK_OF_YEAR, 1);
    return cal.getTime().getTime();
}

public static long getNxtMonthStart()
{
    Calendar cal = Calendar.getInstance();
    cal.clear(Calendar.HOUR_OF_DAY);
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);

    // get start of the month
    cal.set(Calendar.DAY_OF_MONTH, 1);

    // get start of the next month
    cal.add(Calendar.MONTH, 1);

    return cal.getTime().getTime();
}