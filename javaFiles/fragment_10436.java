import java.time.*;
import java.time.format.*;

public class Test {

    public static void main (String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/uuuu");
        // With the "smart" resolver style, it parses
        System.out.println(formatter.getResolverStyle());
        LocalDate date = LocalDate.parse("9/31/2018", formatter);
        System.out.println(date);

        // But with a strict style...
        formatter = formatter.withResolverStyle(ResolverStyle.STRICT);
        LocalDate.parse("9/31/2018", formatter);
    }
}