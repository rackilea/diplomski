import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        String text = "2011-03-10T11:54:30.207Z";
        DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dt = parser.parseDateTime(text);

        DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
        System.out.println(formatter.print(dt));
    }
}