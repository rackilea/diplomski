import java.math.*;
import java.text.*;

public class Test {
    public static void main(String[] args) throws Exception {
        DecimalFormat format = new DecimalFormat();
        format.setParseBigDecimal(true);
        BigDecimal value = (BigDecimal) format.parse("1,234.56");
        System.out.println(value);
    }
}