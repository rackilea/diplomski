import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        List<LocalDateTime> from = new ArrayList<>(5);
        List<LocalDateTime> to = new ArrayList<>(5);

        from.add(LocalDateTime.parse("2018-06-16 02:00:00", formatter));
        from.add(LocalDateTime.parse("2018-06-16 03:00:00", formatter));
        from.add(LocalDateTime.parse("2018-06-16 04:00:00", formatter));
        from.add(LocalDateTime.parse("2018-06-16 05:00:00", formatter));
        from.add(LocalDateTime.parse("2018-06-16 06:00:00", formatter));

        to.add(LocalDateTime.parse("2018-06-18 02:00:00", formatter));
        to.add(LocalDateTime.parse("2018-06-18 03:00:00", formatter));
        to.add(LocalDateTime.parse("2018-06-18 04:00:00", formatter));
        to.add(LocalDateTime.parse("2018-06-18 05:00:00", formatter));
        to.add(LocalDateTime.parse("2018-06-18 06:00:00", formatter));

        for (int index = 0; index < from.size(); index++) {
            LocalDateTime fromDate = from.get(index);
            LocalDateTime toDate = to.get(index);
            String difference = formatDurationBetween(fromDate, toDate);
            System.out.println(fromDate.format(formatter) + " - " + toDate.format(formatter) + " = " + difference);
        }
    }

    public static String formatDurationBetween(LocalDateTime from, LocalDateTime to) {
        Duration difference = Duration.between(from, to);

        long days = difference.toDays();
        difference = difference.minusDays(days);
        long hours = difference.toHours();
        long mins = difference.minusHours(hours).toMinutes();

        return String.format("%dd %dh %02dm", days, hours, mins);
    }

}