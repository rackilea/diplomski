import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class DatesexcludingWeekend {
    public static void main(String[] args) {
        final LocalDate start = new LocalDate(2012, 06, 15);
        final LocalDate end = new LocalDate(2012, 07, 14);
        LocalDate weekday = start;
        if (start.getDayOfWeek() == DateTimeConstants.SATURDAY|| start.getDayOfWeek() == DateTimeConstants.SUNDAY) {
            weekday = weekday.plusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY);
        }

        while (weekday.isBefore(end)) {
            System.out.println(weekday);
            if (weekday.getDayOfWeek() == DateTimeConstants.FRIDAY)
                weekday = weekday.plusDays(3);
            else
                weekday = weekday.plusDays(1);
        }
    }