import java.math.*;

public class Test {
    public static String round(String value, int places) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.toPlainString();
    }

    public static void main(String[] args) throws Exception {
        String value1 = "1.1234565";
        System.out.println(round(value1, 6));
        String value2 = "1.1235";
        System.out.println(round(value2, 3));
    }
}