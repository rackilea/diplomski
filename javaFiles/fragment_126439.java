import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DateSubtractExample{
    public static String backOneDay(String inDate){
      SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,yyyy");
      try{
          // turn your string into a date (if formatting is right)
          Date date1 = formatter.parse(inDate);
          // make a calendar, set it to the date, and subtract one day.
          Calendar cal = Calendar.getInstance();
          cal.setTime(date1);
          cal.add(Calendar.DATE,-1);
          // convert date back to input format. 
          return formatter.format(cal.getTime());
        }
        catch (ParseException bad){
                bad.printStackTrace();
                return "UNREADABLE DATE "+inDate+":"+bad;

        }
    }

    public static void main(String[] args) throws ParseException{
       System.out.println(DateSubtractExample.backOneDay(args[0]));
    }
}