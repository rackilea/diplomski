package area51;

import java.io.PrintStream;

public final class ABCDGuesser1 {

    private ABCDGuesser1() {
    }

    public static void main(String[] args) {

        PrintStream out = System.out;
        //out.print("Enter a positive real-valued universal physical or mathematical constant: ");
        double mu = 2.567;

        //out.print("Enter four postitive numbers not equal to 1: ");
        double w = 123.4;
        double x = 2.567;
        double y = 8.9;
        double z = 12.6;

        double[] charm = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0, 1 / 4, 1 / 3, 1 / 2, 1, 2, 3, 4, 5 };

        double bestEstimate = 0;
        String bestIndexes = "";
        for (int i = 0; i < charm.length; i++) {
            double max1 = (Math.pow(w, charm[i]));
            for (int j = 0; j < charm.length; j++) {
                double max2 = (Math.pow(x, charm[j]));
                for (int k = 0; k < charm.length; k++) {
                    double max3 = (Math.pow(y, charm[k]));
                    for (int n = 0; n < charm.length; n++) {
                        double max4 = (Math.pow(z, charm[n]));
                        double currentEstimate = max1 * max2 * max3 * max4;
                        if (Math.abs(mu - currentEstimate) < Math.abs(mu - bestEstimate)) {
                            bestEstimate = currentEstimate;
                            bestIndexes = ""+i+","+j+","+k+","+n;
                        }
                    }
                    //out.print(max1);
                }
            }
        }
        out.println("Best Estimate = " + bestEstimate);
        out.println("Best Indexes = " + bestIndexes);
    }
}