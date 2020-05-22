import java.util.Calendar;
import java.util.Locale;
public class App {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        if(calendar.isWeekDateSupported()) {
            Calendar cal = Calendar.getInstance(Locale.FRANCE);
            for (int i = 0; i <= 11; i++) {
                int nombreMaxSemaine = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
                System.out.println("Current week number: " + nombreMaxSemaine);
            }
        }
    }
}