import static java.time.ZoneOffset.UTC;
import static java.time.temporal.ChronoUnit.DAYS;

ZonedDateTime truncatedToMonth = ZonedDateTime.now(UTC).truncatedTo(DAYS).withDayOfMonth(1);
System.out.println(truncatedToMonth); //prints 2015-06-01T00:00Z
long millis = truncatedToMonth.toInstant().toEpochMilli();
System.out.println(millis); // prints 1433116800000