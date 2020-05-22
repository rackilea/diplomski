import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.TemporalAdjusters;

// current date/time at system's default timezone
ZonedDateTime now = ZonedDateTime.now();

// get next Tuesday at 08:30 AM
ZonedDateTime nextTuesday = now
    // get the next Tuesday
    .with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
    // at 08:30 AM
    .with(LocalTime.of(8, 30));
System.out.println(nextTuesday);

// get the millis timestamp
long scheduledTime = nextTuesday.toInstant().toEpochMilli();