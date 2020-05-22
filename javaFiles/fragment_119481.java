import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        PeriodFormatter formatter = new PeriodFormatterBuilder()
            .appendHours()
            .appendLiteral(":")
            .appendMinutes()
            .toFormatter();
        Duration duration = formatter.parsePeriod("02:10").toStandardDuration();
        System.out.println(duration);
    }
}