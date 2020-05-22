import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Test051 {

    public static void main(String[] args) throws Exception {
        String pt = "1970-01-01-";
        ArrayList<String> timestampsList = new ArrayList<String>();
        timestampsList.add("01:00:05");
        timestampsList.add("01:00:05");
        timestampsList.add("10:00:05");
        final DateFormat dt = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        final Calendar sum = Calendar.getInstance();
        sum.setTimeInMillis(0);

        long tm0 = new SimpleDateFormat("yyyy-MM-dd").parse(pt).getTime();

        System.out.println("tm0 = " + tm0);

        for (final String t : timestampsList) {
            // System.out.println(dt.parse(pt + t).getTime());
            Date x = dt.parse(pt + t);
            // System.out.println(x.getTime());
            sum.add(Calendar.MILLISECOND, (int)x.getTime());
            sum.add(Calendar.MILLISECOND, (int)-tm0);
        }

        long tm = sum.getTime().getTime();
        System.out.println("tm = " + tm);

        tm = tm / 1000;


        long hh = tm / 3600;
        tm %= 3600;
        long mm = tm / 60;
        tm %= 60;
        long ss = tm;
        System.out.println(format(hh) + ":" + format(mm) + ":" + format(ss));
    }

    private static String format(long s){
        if (s < 10) return "0" + s;
        else return "" + s;
    }
}