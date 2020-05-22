import java.text.*;

public class Test {

    public static void main(String[] args) throws ParseException {
        String value = "Mon Jan 10 00:10:00 GMT+02:00 2011";
        String pattern = "EEE MMM dd HH:mm:ss z yyyy";
        DateFormat format = new SimpleDateFormat(pattern);
        System.out.println(format.parse(value));
    }
}