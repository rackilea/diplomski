import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDivider {

    public static BigDecimal divideAutoScale(BigDecimal val1, BigDecimal val2,
            int scale, RoundingMode roundingMode) {
        BigDecimal result = val1.divide(val2, scale, roundingMode);
        return result.setScale(countScale(result));
    }

    /*
     * Static helper method, returns int scale.
     */

    private static int countScale(BigDecimal bd) {

        if (bd.doubleValue() % 2 == 0) {
            return 0;
        } else {

            String bigDec = bd.toString();
            int counter = 0;

            for (int i = bigDec.length() - 1; i >= 0; i--) {

                if (bigDec.charAt(bigDec.length() - 1) != '0') {
                    break;
                }

                if (bigDec.charAt(i) == '0') {
                    counter++;
                }

                if (bigDec.charAt(i) == '.'
                        || (i > 1 && bigDec.charAt(i) == '0' && bigDec
                                .charAt(i - 1) != '0')) {
                    break;
                }
            }

            return bigDec.substring(bigDec.indexOf('.'), bigDec.length() - 1)
                    .length() - counter;
        }
    }

    /*
     * Example of usage
     */

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("10");
        BigDecimal b2 = new BigDecimal("5");

        BigDecimal result = divideAutoScale(b1, b2, 4, RoundingMode.HALF_UP);
        System.out.println(result);
    }
    }