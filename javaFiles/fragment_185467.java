package your.pack

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created on 3/6/16.
 */
public class Fibonacci {

    private static BigDecimal goldenRatio = new BigDecimal((1 + Math.sqrt(5)) / 2);
    private static BigDecimal goldenRatioMin1 = goldenRatio.subtract(BigDecimal.ONE);
    private static BigDecimal sqrt5 = new BigDecimal(Math.sqrt(5));

    private static BigInteger fib(int n) {
        BigInteger nthTerm = new BigInteger("0");
        if (n == 2)
            nthTerm = BigInteger.ONE;
        else {
            BigDecimal minResult = goldenRatio.pow(n).subtract(goldenRatioMin1.pow(n));
            nthTerm = minResult.divide(sqrt5,0).toBigInteger();

            if (n % 2 == 1 && n < 45){
                nthTerm = nthTerm.add(BigInteger.ONE);
            }

        }
        return nthTerm;
    }

    private static int fib2(int n) {
        int nthTerm = 0;
        if (n == 2)
            nthTerm = 1;
        else {
            double goldenRatio = (1 + Math.sqrt(5)) / 2;
            nthTerm = (int) (Math.round(Math.pow(goldenRatio, n)
                    - Math.pow(1 - goldenRatio, n)) / Math.sqrt(5));

            if (n % 2 == 1 && n < 45)
                nthTerm++;
        }
        return nthTerm;
    }

    public static void main(String []args){
        System.out.println(
                fib(47)
        );
    }

}