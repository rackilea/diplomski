import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;

public class ConvertTimeToAndFromUtc {

    /** @param type If true: local to utc/If false: utc to local */
    private static String doTimeConversion(String time, boolean type) {
        ZoneId localZone = ZoneId.systemDefault();
        LocalTime lt = LocalTime.parse(time);
        LocalDateTime ldt = LocalDate.now(localZone).atTime(lt);
        ZonedDateTime resultTime;
        if (type) {
            resultTime = ldt.atZone(localZone).withZoneSameInstant(ZoneOffset.UTC);
        } else {
            resultTime = ldt.atOffset(ZoneOffset.UTC).atZoneSameInstant(localZone);
        }
        LocalTime newTime = resultTime.toLocalTime();
        return newTime.toString();
    }

    public static void main(String[] args) {
        System.setProperty("user.timezone", "Asia/Gaza");

        System.out.println("09.21 local to UTC: " + doTimeConversion("09:21", true));
        System.out.println("23:13 UTC to local: " + doTimeConversion("23:13", false));
    }

}