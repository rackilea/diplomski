import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Date;

public class MainClass
{
  public static void main(String[] args)
  {
    try {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("es", "ES"));
        df.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
        df.setLenient(false);
        Date date = df.parse("1901-01-01 00:00:00");
        System.out.println(date);
    } catch(Exception ex){
        ex.printStackTrace();
    }

  }
}