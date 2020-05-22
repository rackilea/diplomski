import java.math.BigDecimal;
import java.util.Locale;

public class Tester{
    public static void main(String args[]){
        System.out.println("999 " + displayNumberAmount(new BigDecimal(999.99), Locale.FRENCH));
        System.out.println("1000 " + displayNumberAmount(new BigDecimal(1000.99), Locale.FRENCH));
        System.out.println("1001 " + displayNumberAmount(new BigDecimal(1001.99), Locale.FRENCH));
    }

    public static String displayNumberAmount(Number amount, Locale locale) {
        return String.format(locale, "%1$,.2f", amount);
    }

}