public class PolyRoots {
    private final double[] coeffs; // any number of coefficients.

    public PolyRoots(double... coeffs) {
        this.coeffs = coeffs;
    }

    public double calcY(double x) {
        double ret = coeffs[0];
        for (int i = 1; i < coeffs.length; i++)
            ret = ret * x + coeffs[i];
        return ret;
    }

    public static void main(String[] args) {
        PolyRoots roots = new PolyRoots(1e-3, -2e-2, 0.1, -1, 5);
        for (int i = -10_000; i <= 10_000; i++) {
            double x = i / 1000.0;
            double y = roots.calcY(x);
            System.out.println(x + "\t" + y);
        }
    }
}