/**
 * Calculate distance traveled per second of distraction
 * User: mduffy
 * Date: 8/25/2016
 * Time: 2:40 PM
 * @link http://stackoverflow.com/questions/39152475/feet-to-distractionSeconds-cant-increment-distractionSeconds-java
 */
public class DistractionDistanceCalculator {

    public static final int FEET_PER_MILE = 5280;
    public static final int SECONDS_PER_HOUR = 3600;

    public static void main(String[] args) {
        double mph = (args.length > 0) ? Double.parseDouble(args[0]) : 60.0;
        double distractionSeconds = (args.length > 1) ? Double.parseDouble(args[1]) : 1.0;
        double distance = calculateDistractionDistance(mph, distractionSeconds);
        System.out.println(String.format("You will travel %10.3f feet if you are distracted for %10.3f distractionSeconds at %10.3f mph", distance, distractionSeconds, mph));
    }

    private DistractionDistanceCalculator() {
    }

    public static double calculateDistractionDistance(double mph, double distractionSeconds) {
        if (mph < 0.0) throw new IllegalArgumentException("Speed must be positive");
        if (distractionSeconds < 0.0) throw new IllegalArgumentException("Distraction seconds must be positive");
        return mph*FEET_PER_MILE/SECONDS_PER_HOUR*distractionSeconds;
    }
}