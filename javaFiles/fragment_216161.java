import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.TimeZone;
import java.util.Date;

class Main {
  public static void main(String[] args) {
    DateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    //DateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"); I needed to use XXX in repl.
    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
    DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    try
    {
      String isoString = "2016-08-26T11:03:39.000+01:00";
      Date mDate = isoDateFormat.parse(isoString);
      System.out.println("GMT" + isoString.substring(23));
      TimeZone mTimeZone = TimeZone.getTimeZone("GMT" + isoString.substring(23));
      dateFormat.setTimeZone(mTimeZone);
      timeFormat.setTimeZone(mTimeZone);
      System.out.println(mTimeZone.toString());
      String dateString = dateFormat.format(mDate);
      String timeString = timeFormat.format(mDate);
      System.out.println(dateString + " " + timeString);
    }
    catch(ParseException e)
    {
       System.out.println("Error");
    }
  }
}