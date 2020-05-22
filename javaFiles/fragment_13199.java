import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

Set<String> zoneIds = ZoneId.getAvailableZoneIds();

for (String zoneId : zoneIds) {
    ZoneId zone = ZoneId.of(zoneId);
    ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);

    ZoneOffset offset = zonedDateTime.getOffset();
    String longName = zone.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

    System.out.println("(" + offset + ") " + zoneId + ", " + longName);
}