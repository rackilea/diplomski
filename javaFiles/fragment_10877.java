import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class SimpleDateFormatExample {
 public static void main(String[] args) {
  SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy  HH:mm:ss ",Locale.ENGLISH);
   String strDate= sdf.format(new Date());
   System.out.println(strDate);
 }
}