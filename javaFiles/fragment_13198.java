import java.util.Set;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

Set<String> zoneIds = DateTimeZone.getAvailableIDs();
DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("ZZ");

for (String zoneId : zoneIds) {
    String offset = dateTimeFormatter.withZone(DateTimeZone.forID(zoneId)).print(0);
    String shortName = DateTimeZone.forID(zoneId).getShortName(DateTimeUtils.currentTimeMillis());

    System.out.println("(" + offset + ") " + zoneId + ", " + shortName);
}