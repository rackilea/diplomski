import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        List<LocalDate> dates = new ArrayList<LocalDate>(25);
        dates.add(LocalDate.parse("04/01/2015", dtf));
        dates.add(LocalDate.parse("04/02/2015", dtf));
        dates.add(LocalDate.parse("04/03/2015", dtf));
        dates.add(LocalDate.parse("04/04/2015", dtf));
        dates.add(LocalDate.parse("04/05/2015", dtf));
        dates.add(LocalDate.parse("04/06/2015", dtf));
        dates.add(LocalDate.parse("04/07/2015", dtf));
        dates.add(LocalDate.parse("04/08/2015", dtf));
        dates.add(LocalDate.parse("04/09/2015", dtf));

        int week = 0;
        int woy = -1;
        Collections.sort(dates, new WeekComparator());
        for (LocalDate date : dates) {
            if (woy != getWeekOfYear(date)) {
                woy = getWeekOfYear(date);
                week++;
                System.out.println("Week " + week + ":");
            }
            System.out.println(date);
        }
    }

    public static class WeekComparator implements Comparator<LocalDate> {

        @Override
        public int compare(LocalDate o1, LocalDate o2) {
            int result = getWeekOfYear(o1) - getWeekOfYear(o2);
            if (result == 0) {
                result = o1.compareTo(o2);
            }
            return result;
        }

    }

    protected static int getWeekOfYear(LocalDate date) {
        WeekFields wf = WeekFields.of(Locale.getDefault());
        return date.get(wf.weekOfYear());
    }

}