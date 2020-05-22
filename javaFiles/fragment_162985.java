import java.math.*;

public class Test {

    public static void main(String[] args) {
        test("5000");      // 4
        test("5000.00");   // 4
        test("5000.12");   // 6
        test("35000");     // 5
        test("35000.00");  // 5
        test("35000.12");  // 7
        test("35000.120"); // 7
        test("0.0034");    // 2
        test("1.0034");    // 5
        test("1.00340");   // 5
    }


    private static void test(String input) {
        System.out.println(input + " => " +
            significantDigits(new BigDecimal(input)));
    }

    private static int significantDigits(BigDecimal input) {
        input = input.stripTrailingZeros();
        return input.scale() < 0
            ? input.precision() - input.scale()
            : input.precision(); 
    }
}