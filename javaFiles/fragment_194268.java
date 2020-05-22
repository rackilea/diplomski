import java.util.*;
import java.text.*;

public class Test {
    public static void main(String[] args) throws Exception {
        String text = "Mon, Aug 4, 2014";
        DateFormat format = new SimpleDateFormat("EEE, MMM d, yyy",
                                                  Locale.US);
        Date date = format.parse(text);
        System.out.println(date);
    }
}