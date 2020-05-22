import org.joda.time.*;
import org.joda.time.format.*;

public class Test {
    public static void main(String[] args) {
        // 2 days, 4 hours, 4 minutes
        Period period = new Period(0, 0, 0, 2, 4, 4, 0, 0);

        // Actually we're fine with seconds etc as well
        Period hoursAndMinutes = period.normalizedStandard(PeriodType.time());

        PeriodFormatter formatter = new PeriodFormatterBuilder()
            .appendHours()
            .appendSuffix(" hour", " hours")
            .appendMinutes()
            .appendSuffix(" minute", " minutes")
            .toFormatter();
        System.out.println(formatter.print(hoursAndMinutes));
    }
}