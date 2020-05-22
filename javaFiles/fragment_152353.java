import java.util.*;
import java.text.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        String inputText = "Tue May 21 14:32:00 GMT 2012";
        SimpleDateFormat inputFormat = new SimpleDateFormat
            ("EEE MMM dd HH:mm:ss 'GMT' yyyy", Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

        SimpleDateFormat outputFormat =
            new SimpleDateFormat("MMM dd, yyyy h:mm a");
        // Adjust locale and zone appropriately
        Date date = inputFormat.parse(inputText);
        String outputText = outputFormat.format(date);
        System.out.println(outputText);
    }
}