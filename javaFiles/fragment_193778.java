import org.joda.time.*;

public class Test {
    public static void main(String[] args) {
        DateTime start = DateTime.now();
        DateTime end = new DateTime(2012, 12, 25, 0, 0, 0, 0);
        System.out.println(end.getMillis() - start.getMillis());
    }
}