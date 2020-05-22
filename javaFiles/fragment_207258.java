public class CurrencyFormatExample {
    public void currencyFormat(Locale currentLocale) {
        Double currency = new Double(9843.21);
        NumberFormat currencyFormatter;
        String currencyOut;
        currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        currencyOut = currencyFormatter.format(currency);
        System.out.println(currencyOut + " " + currentLocale.toString());
    }

    public static void main(String args[]) {
        Locale[] locales = new Locale[]{new Locale("fr", "FR"),
            new Locale("de", "DE"), new Locale("ca", "CA"),
            new Locale("rs", "RS"),new Locale("en", "IN")
        };
        CurrencyFormatExample[] formate = new CurrencyFormatExample[locales.length];
        for (int i = 0; i < locales.length; i++) {
            formate[i].currencyFormat(locales[i]);
        }
    }
}