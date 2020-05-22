public class CurrencyTest {
    public static void main(String[] args) throws Exception {
        Locale defaultLocale = Locale.getDefault();
        displayCurrencyInfoForLocale(defaultLocale);

        Locale swedishLocale = new Locale("sv", "SE");
        displayCurrencyInfoForLocale(swedishLocale);
    }

    public static void displayCurrencyInfoForLocale(Locale locale) {
        System.out.println("Locale: " + locale.getDisplayName());
        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency Code: " + currency.getCurrencyCode());
        System.out.println("Symbol: " + currency.getSymbol());
        System.out.println("Default Fraction Digits: " + currency.getDefaultFractionDigits());
        System.out.println();
    }
}