package problems.outputDateAsFormatX;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOutput {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        Date currentDate = new Date();
        String currentDateString = dateFormat.format(currentDate);
        System.out.println("My date is: " + currentDateString);
    }
}