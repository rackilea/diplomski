import java.util.*;
import org.joda.time.*;
import org.joda.time.format.*;

public class Test {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy")
            .withLocale(Locale.UK);

        LocalDate date = formatter.parseLocalDate("18/08/2012");

        System.out.println(date.getYear());  // 2012
        System.out.println(date.getMonthOfYear()); // 8
        System.out.println(date.getDayOfMonth());   // 18
    }
}