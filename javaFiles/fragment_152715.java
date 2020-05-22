import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SdfTest {
   public static void main(String[] args) {
      SimpleDateFormat sdfInput = new SimpleDateFormat("yyyyMMdd");
      SimpleDateFormat sdfOutput = new SimpleDateFormat("MMMM dd, yyyy");

      try {
         Date date = sdfInput.parse("20120411");
         String output = sdfOutput.format(date);
         System.out.println(output);

      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
}