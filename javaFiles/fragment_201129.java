import java.util.*;

public class Test {

    public static void main(String [] args) throws Exception {
        // Five and a half hours
        int offsetMilliseconds = (5 * 60 + 30) * 60 * 1000;
        for (String id : findTimeZones(System.currentTimeMillis(),
                                       offsetMilliseconds)) {
            System.out.println(id);
        }
    }

    public static List<String> findTimeZones(long instant,
                                             int offsetMilliseconds) {
        List<String> ret = new ArrayList<String>();
        for (String id : TimeZone.getAvailableIDs()) {
            TimeZone zone = TimeZone.getTimeZone(id);
            if (zone.getOffset(instant) == offsetMilliseconds) {
                ret.add(id);
            }
        }
        return ret;
    }
}