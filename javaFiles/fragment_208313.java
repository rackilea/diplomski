import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Hols {
   public static void main( String[] args ) throws ParseException {
      DateFormat df = new SimpleDateFormat("dd MM yyyy");
      Date start = df.parse( args[0] );
      Date end   = df.parse( args[1] );
      Calendar startDate = new GregorianCalendar();
      Calendar endDate = new GregorianCalendar();
      startDate.setTime(start);
      endDate.setTime(end);
      if( isDateInCurrentWeek( startDate ) && isDateInCurrentWeek( endDate ))
         System.out.println( "Date is in current week!" );
      else
         System.out.println( "Date is NOT in current week!" );
   }

   public static boolean isDateInCurrentWeek( Calendar date ) {
      Calendar currentCalendar = Calendar.getInstance();
      int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
      int year = currentCalendar.get(Calendar.YEAR);
      Calendar targetCalendar = Calendar.getInstance();
      targetCalendar = date;
      int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
      int targetYear = targetCalendar.get(Calendar.YEAR);
      return week == targetWeek && year == targetYear;
   }
}