import java.util.Arrays;

public class MathUtils {
    // interpolates non linear date through the ordinary least squares method
    public static TripleValue calculatepar(double v1[], double v2[]) {
        int n = v1.length;
        if (n == 0 || n != v2.length) {
            // invalid values passed in; throw an exception here
            String message = String.format("For values v1: %s and v2: %s",
                    Arrays.toString(v1),
                    Arrays.toString(v2));
            throw new IllegalArgumentException(message);
        }
        double sumv1 = 0;
        double sumv2 = 0;
        double avrx = sumv1 / n;
        double avry = sumv2 / n;
        double[] v3 = new double[n];
        double sumv32 = 0;
        double sumv34 = 0;
        double sumv3v2 = 0;
        double sumv32y = 0;

        for (double z : v1)
            sumv1 += z;
        for (double z : v2)
            sumv2 += z;

        for (int i = 0; i < n; i++)
            v3[i] = (v1[i] - avrx);
        for (int i = 0; i < n; i++) {
            sumv32 += Math.pow(v3[i], 2);
        }
        for (int i = 0; i < n; i++) {
            sumv34 += Math.pow(v3[i], 4);
        }
        for (int i = 0; i < n; i++) {
            sumv3v2 += v3[i] * v2[i];
        }
        for (int i = 0; i < n; i++) {
            sumv32y += (Math.pow(v3[i], 2)) * v2[i];
        }

        double c = ((n * sumv32y) - (sumv2 * sumv32)) / ((n * sumv34) - (Math.pow(sumv32, 2)));
        double b = sumv3v2 / sumv32;
        double a = ((sumv2 * sumv34) - (sumv32 * sumv32y)) / ((n * sumv34) - (Math.pow(sumv32, 2)));

        return new TripleValue(a, b, c);
    }

    // other calculation methods go here
}