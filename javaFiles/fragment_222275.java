import java.time.*;
import java.time.format.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.US);

        String text = "2011-02-18 05:00:00.0";
        LocalDateTime localDateTime = LocalDateTime.parse(text, formatter);
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
    }
}