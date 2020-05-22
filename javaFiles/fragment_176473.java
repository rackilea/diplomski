import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;

public class SO201904030814 {

    public SO201904030814() {
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf3 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

        Date d1 = sdf3.parse(String.valueOf("Mon Mar 04 12:19:50 GMT+05:30 2019"));

        LocalDateTime dateTime = LocalDateTime.ofInstant(d1.toInstant(), ZoneOffset.of("+05:30"));

        System.out.println("check..." + d1 + " vs " + dateTime);

    }

}