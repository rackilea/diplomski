import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

class TestTz {

  public static void main(String[] args)
  {
     final DateTimeZone dtz = DateTimeZone.forID("CET");
     LocalDateTime ldt = new LocalDateTime(dtz)
       .withYear(2011)
       .withMonthOfYear(3)
       .withDayOfMonth(27)
       .withHourOfDay(2);

    // this is just here to illustrate I'm solving the problem; 
    // don't need in operational code
    try {
      DateTime myDateBorken = ldt.toDateTime(dtz);
    } catch (IllegalArgumentException iae) {
      System.out.println("Sure enough, invalid instant due to time zone offset transition!");
    }

    if (dtz.isLocalDateTimeGap(ldt)) {
      ldt = ldt.withHourOfDay(3);
    }

    DateTime myDate = ldt.toDateTime(dtz);
    System.out.println("No problem: "+myDate);
  }

}