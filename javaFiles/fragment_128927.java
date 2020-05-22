import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatesInYear {

    public static void main(final String[] args) throws Exception {

        listWorkingDays(2020).forEach(System.out::println);
    }

    private static List<LocalDate> listWorkingDays(final int year) {

        IntStream
            .rangeClosed(1,      LocalDate.ofYearDay(year + 1, 1).minusDays(1).getDayOfYear())
            .mapToObj   (day  -> LocalDate.ofYearDay(year, day))
            .filter     (date -> date.getDayOfWeek().getValue() <= 5)
            .forEach    (System.out::println);

        return IntStream
            .rangeClosed(1,      LocalDate.ofYearDay(year + 1, 1).minusDays(1).getDayOfYear())
            .mapToObj   (day  -> LocalDate.ofYearDay(year, day))
            .filter     (date -> date.getDayOfWeek().getValue() <= 5)
            .collect    (Collectors.toList());
    }
}