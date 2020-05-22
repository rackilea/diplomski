import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        Date date = new Date();
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df2.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println(ISO8601Utils.format(date, true));
        System.out.println(df2.format(date));
    }
}