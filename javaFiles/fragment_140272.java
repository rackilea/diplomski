import java.util.Currency;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReceiptOcr {

    public static void main(String[] args) {
//      String poundSymbol = Currency.getInstance(Locale.UK).getSymbol();
        String poundSymbol = "£";
        String[] inputStrings = {
                "CHOC. ORANGE    x         " + poundSymbol + "1.00"
                , "CHOC. ORANGE    x         L1.00"
        };

        String regex = "(?<description>.+)"
                + "\\s{2,}"                             // two or more white space
                + "(?<currency>"+poundSymbol+"|\\w)"    // Pound symbol may be mis-reaad
                + "(?<amount>\\d+\\.\\d{2})";
        Pattern p = Pattern.compile(regex);
        for (String inputString : inputStrings) {
            Matcher m = p.matcher(inputString);
            if (m.find()) {
                String description  = m.group("description");
                String currency     = m.group("currency");
                String amountString = m.group("amount");

                System.out.format("Desciption: %s%n"
                        + "Currency: %s%n"
                        + "Amount: %s%n"
                        , description.trim()
                        , currency
                        , amountString);
            }
        }
    }

}