import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Test051 {

    public static void main(String[] args) throws Exception {
        ArrayList<String> timestampsList = new ArrayList<String>();
        timestampsList.add("01:00:00");
        timestampsList.add("02:00:00");
        timestampsList.add("03:00:00");
        timestampsList.add("04:00:00");
        timestampsList.add("02:00:00");
        timestampsList.add("04:00:00");

        Date dt0 = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");

        // Check very carefully the output of this one.
        System.out.println(dt0.getTime());

        final DateFormat dt = new SimpleDateFormat("HH:mm:ss");
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(0);
        for (final String t : timestampsList) {
            c.add(Calendar.MILLISECOND, (int) dt.parse(t).getTime());
            c.add(Calendar.MILLISECOND, (int)-dt0.getTime());
        }

        // We need to add this back. This is basically the time zone offset.
        c.add(Calendar.MILLISECOND, (int)dt0.getTime());

        System.out.println(c.getTime().getTime());
        System.out.println(c.getTimeInMillis());

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
    }

}