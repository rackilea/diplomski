import java.time.*;
import java.util.regex.*;

public class MyClass {
    public static void main(String args[]) {
        LocalDate today = LocalDate.now();
        long storagePeriod = 5L;
        String fileName = "file_20180804";
        int year = 0;
        int month = 0;
        int day = 0;

        String pattern = "file_(\\d{4})(\\d{2})(\\d{2})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(fileName);

        if (m.find()) {
            year = Integer.parseInt(m.group(1));
            month = Integer.parseInt(m.group(2));
            day = Integer.parseInt(m.group(3));
        }

        LocalDate fileDate = LocalDate.of(year, month, day);

        if (fileDate.isBefore(today.minusDays(storagePeriod))) {
            System.out.println("Delete this file");
        }
    }
}