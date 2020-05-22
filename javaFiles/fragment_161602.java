import java.time.*;

    LocalDateTime currentDateTime = LocalDateTime.now();
    ZoneId zoneId = ZoneId.of("US/Eastern");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(currentDateTime, zoneId);
    Instant instant = zonedDateTime.toInstant();