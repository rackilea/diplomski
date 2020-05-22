//import org.joda.time.format.PeriodFormatter;
//import org.joda.time.format.PeriodFormatterBuilder;
//import org.joda.time.Duration;

Duration duration = new Duration(123456); // in milliseconds
PeriodFormatter formatter = new PeriodFormatterBuilder()
     .appendDays()
     .appendSuffix("d")
     .appendHours()
     .appendSuffix("h")
     .appendMinutes()
     .appendSuffix("m")
     .appendSeconds()
     .appendSuffix("s")
     .toFormatter();
String formatted = formatter.print(duration.toPeriod());
System.out.println(formatted);