import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        BigDecimal inputOne = new BigDecimal("95.123");
        int power = 12;
        BigDecimal result = inputOne.pow(power);
        System.out.println(result);
    }
}