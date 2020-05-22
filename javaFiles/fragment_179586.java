import java.text.*;
import java.util.*;

public class TimeZoneTest {

    public static void main(final String[] args) throws ParseException {

        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        final String string = "2014-01-02T23:03:30-05:00";
        final Date date = format.parse(string);
        System.out.println(date);
    }
}