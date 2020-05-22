import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            List<Date> dates = new ArrayList<Date>(25);
            dates.add(sdf.parse("04/01/2015"));
            dates.add(sdf.parse("04/02/2015"));
            dates.add(sdf.parse("04/03/2015"));
            dates.add(sdf.parse("04/04/2015"));
            dates.add(sdf.parse("04/05/2015"));
            dates.add(sdf.parse("04/06/2015"));
            dates.add(sdf.parse("04/07/2015"));
            dates.add(sdf.parse("04/08/2015"));
            dates.add(sdf.parse("04/09/2015"));

            int week = 0;
            int woy = -1;
            Collections.sort(dates, new WeekComparator());
            for (Date date : dates) {
                if (woy != getWeekOfYear(date)) {
                    woy = getWeekOfYear(date);
                    week++;
                    System.out.println("Week " + week + ":");
                }
                System.out.println(date);
            }

        } catch (ParseException exp) {
            exp.printStackTrace();
        }
    }

    public static class WeekComparator implements Comparator<Date> {

        @Override
        public int compare(Date o1, Date o2) {
            int result = getWeekOfYear(o1) - getWeekOfYear(o2);
            if (result == 0) {
                result = o1.compareTo(o2);
            }
            return result;
        }

    }

    protected static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

}