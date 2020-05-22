import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        DateTimeZone zone = DateTimeZone.forID("Europe/London");
        Instant now = new Instant();
        long offset = zone.getStandardOffset(now.getMillis());
        System.out.println("Offset = " + offset);
        DateTimeFormatter format = DateTimeFormat.forPattern("ZZ")
                                                 .withZone(zone);
        System.out.println(format.print(offset));
    }
}