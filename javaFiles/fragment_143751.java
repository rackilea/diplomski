public class Random {

    private static double second;
    private static boolean secondValid = false;

    static double normal(int stream, double mean, double std) {
        double v1, v2, y1, y2, x1, x2, w;

        if (secondValid) {
            secondValid = false;
            return second;
        }

        do {
            v1 = 2 * RandomGenerator.rand(stream) - 1;
            v2 = 2 * RandomGenerator.rand(stream) - 1;
            w = v1 * v1 + v2 * v2;
        } while (w > 1);

        y1 = v1 * Math.sqrt(-2 * Math.log(w) / w);
        y2 = v2 * Math.sqrt(-2 * Math.log(w) / w);
        x1 = mean + y1 * std;
        x2 = mean + y2 * std;
        second = x2;
        secondValid = true;
        return x1;
    }

}