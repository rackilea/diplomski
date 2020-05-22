import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyClass {
    public static void main(String args[]) {
        List<HardCurrency> hardCurrencies = Arrays.asList(HardCurrency.values());
        Collections.sort(hardCurrencies, new HardCurrencyInverseComparator());
        for (HardCurrency hc : hardCurrencies) {
            System.out.println(hc.getValue());
        }
    }

    enum HardCurrency {
        ONE(1), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100), FIVE_HUNDRED(
                500), TWO_THOUSAND(2000);

        private final BigDecimal value;

        HardCurrency(int value) {
            this.value = new BigDecimal(value);
        }

        public BigDecimal getValue() {
            return value;
        }

    }

    static class HardCurrencyInverseComparator implements Comparator<HardCurrency> {

        public int compare(HardCurrency currency1, HardCurrency currency2) {
            return currency2.getValue().compareTo(currency1.getValue());
        }

    }




}