import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal("28.0");
        BigDecimal y = new BigDecimal("5.6");

        BigDecimal div = x.divide(y);
        BigDecimal rem = x.remainder(y);

        System.out.println(div); // Prints 5
        System.out.println(rem); // Prints 0.0
    }
}