public class FormulaTest {
    static double formula1(double t0, double t1) {
        return (1000 * t1 - 1000 * t0) / 1000;
    }

    static double formula2(double t0, double t1) {
        return t1 - t0;
    }

    static void printResults(double t0, double t1) {
        System.out.println("t0: " + t0);
        System.out.println("t1: " + t1);
        System.out.println("Formula1: " + formula1(t0, t1));
        System.out.println("Formula2: " + formula1(t0, t1));
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        printResults(0, 10);
        printResults(System.currentTimeMillis(), System.currentTimeMillis());
        printResults(System.currentTimeMillis(), System.currentTimeMillis() + 142);
        printResults(1.7976931348623157e+300 - 5000, 1.7976931348623157e+300);
        printResults(
            109999999999999999999999999999999999999999999999999999999999999999999999.0,
            119999999999999999999999999999999999999999999999999999999999999999999999.0);
        printResults(
            10.9999999999999999999999999999999999999999999999999999999999999999999999,
            11.9999999999999999999999999999999999999999999999999999999999999999999999);
        printResults(
            823145321462149234.651985149616914621346234923149621346921394613293423951932415934159213226314,
            844329146321496321.532159341563149513495139159341593415793415431951349513891585443951391593151);
        printResults(
            82314532.1462149234651985149616914621346234923149621346921394613293423951932415934159213226314,
            84432914.6321496321532159341563149513495139159341593415793415431951349513891585443951391593151);
        printResults(1.7976931348623157e+307, 4.9e-323);
        printResults(Double.MAX_VALUE, Double.MAX_VALUE);
        printResults(Double.MIN_VALUE - 10, Double.MIN_VALUE);
    }
}