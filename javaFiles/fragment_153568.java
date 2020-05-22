import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    public static void main(String[] args) throws Exception {
        Date dt = new Date();
        printDates(dt);

        String str = "May 21 1980";
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy");
        Date date = df.parse(str);
        long epoch = date.getTime();

        Date dl = new Date(epoch);
        printDates(dl);

            System.out.println("\nDifference Days: " + Diff(dl,dt) + " hari");
    }
    public static long Diff(Date dl, Date dt) {
        long diffdays = dt.getTime() - dl.getTime();
        long days = diffdays / (24 * 60 * 60 * 1000);
        return days;
    }


    public static void printDates(Date date){
          DateFormat[] dlformat = new DateFormat[6];
          dlformat[0] = DateFormat.getInstance();
          dlformat[1] = DateFormat.getDateInstance();
          dlformat[2] = DateFormat.getDateInstance(DateFormat.MEDIUM);
          dlformat[3] = DateFormat.getDateInstance(DateFormat.FULL);
          dlformat[4] = DateFormat.getDateInstance(DateFormat.LONG);
          dlformat[5] = DateFormat.getDateInstance(DateFormat.SHORT);
          System.out.println("\nDate of Birth :");
          for(DateFormat dateform : dlformat)
          System.out.println(dateform.format(date));
    }
}