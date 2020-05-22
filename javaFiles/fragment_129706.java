import javax.xml.bind.DatatypeConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {    
    public static void main(String[] args) throws ParseException {
        convert("0001-01-01T00:00:00");
        convert("1000-01-01T00:00:00");
        convert("1580-01-01T00:00:00");
        convert("1590-01-01T00:00:00");
        convert("1980-03-01T00:00:00");
    }

    private static void convert(String input) throws ParseException {
        Calendar datatypeConverterResult = DatatypeConverter.parseDateTime(input);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date sdfResult = simpleDateFormat.parse(input);

        System.out.println("Input: " + input);
        long datatypeConverterMillis = datatypeConverterResult.getTimeInMillis();
        long sdfResultMillis = sdfResult.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(datatypeConverterMillis - sdfResultMillis);
        System.out.println("DatatypeConverter epoch millis: " + datatypeConverterMillis);
        System.out.println("SimpleDateTime epoch millis: " + sdfResultMillis);
        System.out.println("Difference in days: " + days);
        System.out.println("Parsed calendar time zone: " + datatypeConverterResult.getTimeZone().getID());
        System.out.println();
    }
}