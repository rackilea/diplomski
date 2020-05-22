import java.util.Map;
import java.util.TreeMap;

/**
 * Euler integration of first order ODE for emptying a tank through a nozzle.
 * User: mduffy
 * Date: 12/7/18
 * Time: 7:54 AM
 * @link https://stackoverflow.com/questions/53669186/how-can-i-replace-the-value-of-a-variable-with-a-value-from-another-variable-in/53669375?noredirect=1#comment94196737_53669375
 */
public class Hydraulics {

    private static final double AREA_TANK = 1005.39/20.0;
    private static final double AREA_NOZZLE = 0.0218209;
    private static final double MASS_RATE_CONSTANT = 8.02;


    public static void main(String[] args) {
        double height = 20.0;
        int time = 0;
        int dt = 60;
        double tolerance = 1.0e-1;
        Map<Integer, Double> results = new TreeMap<>();
        while (height > tolerance) {
            results.put(time, height);
            height += derivative(time, height)*dt;
            time += dt;
        }
        System.out.println("Time  Height");
        for (int t : results.keySet()) {
            System.out.println(String.format("%5d %10.3f", t, results.get(t)));
        }
    }

    private static double derivative(int time, double height) {
        return -MASS_RATE_CONSTANT*AREA_NOZZLE*Math.sqrt(height)/AREA_TANK;
    }
}