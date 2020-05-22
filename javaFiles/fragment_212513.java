import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) throws Exception {
        DateTime date = new DateTime(0, DateTimeZone.forID("Europe/London"));

        DateTimeFormatter formatter = DateTimeFormat.forPattern(
            "dd MMM yyyy HH:mm:ss Z");

        String text = formatter.print(date); // 01 Jan 1970 01:00:00 +0100
        System.out.println(text);

        DateTime parsed = formatter.parseDateTime(text);
        System.out.println(parsed.equals(date)); // true
    }
}