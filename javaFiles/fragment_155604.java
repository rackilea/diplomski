import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Test {

    public static void main(String[] args) throws Exception {        
        DateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy",
                                              Locale.US);
        sdf.parse("Sun Dec 13 10:00:00 UTC 2009");
    }
}