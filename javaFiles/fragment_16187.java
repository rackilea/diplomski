import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#,###.##########");

        Double number = new Double(1234567.8901234567d);
        String amount = formatter.format(number);
        System.out.println("amount: " + amount);

        String expected = "1,234,567.8901234567";
        assert(expected.equals(amount));

        number = new Double(-1234567.8901234567d);
        amount = formatter.format(number);
        System.out.println("amount: " + amount);
        expected = "-1,234,567.8901234567";
        assert(expected.equals(amount));

        number = new Double(12.89d);
        amount  = formatter.format(number);
        System.out.println("amount: " + amount);
        expected = "12.89";
        assert(expected.equals(amount));
    }
}