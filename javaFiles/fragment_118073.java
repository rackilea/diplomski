import java.util.*;
import java.text.*;

public class Test {
  public static void main(String[] args) {
      Date date = new Date(1111111111);
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
      df.setTimeZone(TimeZone.getTimeZone("UTC"));
      // Prints 1970-01-13 20:38:31 UTC
      System.out.println(df.format(date));
  }
}