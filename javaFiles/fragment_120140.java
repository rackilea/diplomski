import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormatter {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        cal.set(2015, 7, 3);

        SimpleDateFormat sdf = new SimpleDateFormat("dMMM yyyy");

        System.out.println("Formatted Date :  " + sdf.format(cal.getTime()));
    }

}