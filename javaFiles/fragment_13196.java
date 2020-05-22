import java.util.Set;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

Set<String> zoneIds = DateTimeZone.getAvailableIDs();
DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("ZZ");

for (String zoneId : zoneIds) {
    String offset = dateTimeFormatter.withZone(DateTimeZone.forID(zoneId)).print(0);
    String longName = TimeZone.getTimeZone(zoneId).getDisplayName();

    System.out.println("(" + offset + ") " + zoneId + ", " + longName);
}