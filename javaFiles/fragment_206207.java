import java.util.Calendar;
import javax.xml.bind.DatatypeConverter;

public class TestISO8601 {
    public static void main(String[] args) {
        parse("2012-10-01T19:30:00+02:00"); // UTC+2
        parse("2012-10-01T19:30:00Z");      // UTC
        parse("2012-10-01T19:30:00");       // Local
    }
    public static Date parse(final String str) {
        Calendar c = DatatypeConverter.parseDateTime(str);
        System.out.println(str + "\t" + (c.getTime().getTime()/1000));
        return c.getTime();
    }
}