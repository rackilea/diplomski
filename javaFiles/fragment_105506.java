/**
 * Returns PI estimation based on equation:
 * {@code PI' = 4*(1/1 - 1/3 + 1/5 - 1/7 ... 1/m)}
 * 
 * @param n number of fractions in sum.
 */ 
public static double piEstimate(int n) {
    double sum = 0;
    for (int i = 0; i < n; i++) {
        double fraction = (double) 1/(i*2+1);
        int sign = (i % 2 == 0) ? 1 : -1;
        sum += sign * fraction;
    }
    return 4*sum;
}

public static void main(String[] args) {
    System.out.println("PI = " + piEstimate(10000));
}