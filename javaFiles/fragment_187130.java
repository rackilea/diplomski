import java.util.Date;
import java.util.Calendar;

public class source {
    public static void main(String[] args) {
         Calendar endOfYear = Calendar.getInstance();
         endOfYear.setTime(new Date(0));
         endOfYear.set(Calendar.DAY_OF_MONTH, 31);
         endOfYear.set(Calendar.MONTH, 11);
         endOfYear.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
         Calendar today = Calendar.getInstance();
         long t =  endOfYear.getTimeInMillis() - today.getTimeInMillis();
         long seconds =  ( t / 1000 ) % 60 ;
         long minutes =  ( t / 1000 / 60 ) % 60;
         long hours =  (t / ( 1000 * 60 * 60 ) ) % 24 ;
         long days = t / ( 1000 * 60 * 60 * 24 );
         System.out.printf(days + " days, " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds\n");
    }
}