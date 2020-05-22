import org.joda.time.DateTime;
import org.joda.time.Seconds;


public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
         DateTime start = new DateTime(2013, 07, 14, 12, 45, 0);
          DateTime end = new DateTime(2013, 07, 14, 21, 0, 0);

          Seconds diff = Seconds.secondsBetween(start, end);
          System.out.println(diff.getSeconds());

    }

}