import java.math.BigDecimal;
import java.math.MathContext;

public class Test {
    public static void main(String[] args) {
        //double d = ((0.053800 * (500000/1000)) + 4) * 0.85;
        BigDecimal d = ((new BigDecimal(0.053800).multiply(new BigDecimal(500000).divide(new BigDecimal(1000)))).add(new BigDecimal(4))).multiply(new BigDecimal(0.85));
        System.out.println(d.round(MathContext.DECIMAL32));
    }
}