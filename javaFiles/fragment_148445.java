import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {
    public static void main(String args[]){
        // OK
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.clear();
        now.set(2011, 0, 2);
        now.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(("2011-01-01".equals(format.format(now.getTime())) ));
        System.out.println(format.format(now.getTime()));

        // OK
        format = new SimpleDateFormat("yyyy-MM-dd");
        now = Calendar.getInstance();
        now.clear();
        now.set(2017, 0, 2);
        now.add(Calendar.DAY_OF_MONTH, -1);     
        System.out.println(("2017-01-01".equals(format.format(now.getTime())) ));
        System.out.println(format.format(now.getTime()));

        // OK
        format = new SimpleDateFormat("yyyy-MM-dd");
        now = Calendar.getInstance();
        now.clear();
        now.set(2017, 0, 5);
        now.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(("2017-01-04".equals(format.format(now.getTime())) ));
        System.out.println(format.format(now.getTime()));

        // OK
        format = new SimpleDateFormat("yyyy-MM-dd");
        now = Calendar.getInstance();
        now.clear();
        now.set(2016, 0, 2);
        now.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(("2016-01-01".equals(format.format(now.getTime())) ));
        System.out.println(format.format(now.getTime()));
    }
}