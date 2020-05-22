import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
  .appendPattern("MM/dd/yy[ HH:mm:ss]")
  .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
  .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
  .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
  .toFormatter();

LocalDateTime localDateTime1 = LocalDateTime.parse("08/14/18 19:06:17", formatter);
LocalDateTime localDateTime2 = LocalDateTime.parse("08/14/18 19:08:19", formatter);

System.out.println(ChronoUnit.MILLIS.between(localDateTime1, localDateTime2));

// Result: 122000 ms