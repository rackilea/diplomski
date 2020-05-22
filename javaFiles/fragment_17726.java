import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String text = "Event=ThermostatNight,time=0\n" +
                "Event=LightOn,time=2000\n" +
                "Event=WaterOff,time=10000 \n" +
                "Event=ThermostatDay,time=12000\n" +
                "Event=Bell,time=9000,rings=5\n" +
                "Event=WaterOn,time=6000\n" +
                "Event=LightOff,time=4000\n" +
                "Event=Terminate,time=20000\n" +
                "Event=FansOn,time=7000\n" +
                "Event=FansOff,time=8000";

        /*
         * Event=(?<eventName>[^,]+?),time=(?<time>[\d]+)(,rings=(?<rings>[\d]+))?
         *
         * Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Default line breaks
         *
         * Match the character string “Event=” literally (case sensitive) «Event=»
         * Match the regex below and capture its match into a backreference named “eventName” (also backreference number 1) «(?<eventName>[^,]+?)»
         *    Match any character that is NOT a “,” «[^,]+?»
         *       Between one and unlimited times, as few times as possible, expanding as needed (lazy) «+?»
         * Match the character string “,time=” literally (case sensitive) «,time=»
         * Match the regex below and capture its match into a backreference named “time” (also backreference number 2) «(?<time>[\d]+)»
         *    Match a single character that is a “digit” (ASCII 0–9 only) «[\d]+»
         *       Between one and unlimited times, as many times as possible, giving back as needed (greedy) «+»
         * Match the regex below and capture its match into backreference number 3 «(,rings=(?<rings>[\d]+))?»
         *    Between zero and one times, as many times as possible, giving back as needed (greedy) «?»
         *    Mixing named and numbered capturing groups is not recommended.  The numbering of named groups is inconsistent among regex flavors.  Give this group a name, or make it non-capturing. «(»
         *    Match the character string “,rings=” literally (case sensitive) «,rings=»
         *    Match the regex below and capture its match into a backreference named “rings” (also backreference number 4) «(?<rings>[\d]+)»
         *       Match a single character that is a “digit” (ASCII 0–9 only) «[\d]+»
         *          Between one and unlimited times, as many times as possible, giving back as needed (greedy) «+»
         */
        Pattern regex = Pattern.compile("Event=(?<eventName>[^,]+?),time=(?<time>[\\d]+)(,rings=(?<rings>[\\d]+))?");
        Matcher matcher = regex.matcher(text);
        while (matcher.find()) {
            String eventName = matcher.group("eventName");
            int time = Integer.parseInt(matcher.group("time"));

            Integer rings = null;
            if (matcher.group("rings") != null) {
                rings = Integer.parseInt(matcher.group("rings"));
            }

            System.out.println("EventName: " + eventName + " time: " + time + " rings: " + rings);
        }
    }
}