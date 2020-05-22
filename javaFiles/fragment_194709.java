import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yyyy");

        LocalDate start = LocalDate.of(2017, 1, 15);
        LocalDate end = LocalDate.of(2017, 5, 27);
        List<String> months = new ArrayList<>();

        LocalDate date = start;
        if (date.getDayOfMonth() == 1) {
            date = date.minusDays(1);
        }

        while (date.isBefore(end)) {
            if (date.plusMonths(1).with(lastDayOfMonth()).isAfter(end)) {
                break;
            }

            date = date.plusMonths(1).withDayOfMonth(1);
            months.add(date.format(formatter).toUpperCase());
        }

        System.out.println(months);
    }

}