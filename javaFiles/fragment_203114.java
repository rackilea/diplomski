import java.math.BigDecimal;

public class BigDecTest {
    public static final void main(String[] args) {
        BigDecimal a = new BigDecimal("0.000001");
        System.out.println(String.format("%6.4G",a));

        BigDecimal b = new BigDecimal("0.2222" );
        System.out.println(String.format("%6.4G", b));
    }
}