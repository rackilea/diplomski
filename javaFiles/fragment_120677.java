import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class TestFormat {

  public static void main(String[] args) {
    PeriodFormatter hoursMinutesSeconds = new PeriodFormatterBuilder()
    .printZeroAlways()
    .appendHours().appendSuffix(" hour", " hours")
    .printZeroRarelyFirst()
    .appendSeparator(", ", " and ")
    .appendMinutes()
    .appendSuffix(" minute", " minutes")
    .appendSeparator(" and ")
    .appendSeconds()
    .appendSuffix(" second", " seconds")
    .toFormatter();
     System.out.println(hoursMinutesSeconds.print(new Period(0, 0, 0, 0)));
  }
}