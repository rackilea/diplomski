import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
DateTimeFormatter formatter = DateTimeFormatter
        .ofPattern("yyyy-MM-dd'T'HH:mm:ss.S O")
        .withLocale(Locale.ENGLISH)
String date = formatter.format(ZonedDateTime.now(ZoneOffset.UTC));
formatter.parse(date)