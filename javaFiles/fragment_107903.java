import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
   public static void main(String[] args) {
      String[] tests = {"01/23/1983", "1/23/1983", "1/3/1983"};

      String formatString = "MM/dd/yyyy";

      SimpleDateFormat sdf = new SimpleDateFormat(formatString);

      for (String test : tests) {
         Date date = null;
         try {
            date = sdf.parse(test);
         } catch (ParseException e) {
            e.printStackTrace();
         }
         System.out.println(date);
      }
   }
}