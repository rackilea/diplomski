import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateFormatExample {

    private static SimpleDateFormat offsetDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ssZ");

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat(
            "ddMMMyyyyHHmm");

    public static void main(String[] args) throws ParseException {
        String date = "15Sep20162040";
        String result = offsetDateFormat.format(dateFormatter.parse(date));
        System.out.println(result); // 2016-09-15T20:40:00+0400
        offsetDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
        result = offsetDateFormat.format(dateFormatter.parse(date));
        System.out.println(result);
    }
}