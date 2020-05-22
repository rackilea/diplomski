public class MyCurrency {
    public static void main(String[] args) {
        System.out.println(format(Locale.FRANCE, 1234.56f));
        System.out.println(format(Locale.TAIWAN, 1234.56f));
    }

    public static String format(Locale locale, Float value) {
        NumberFormat cfLocal = NumberFormat.getCurrencyInstance(locale);
        return cfLocal.format(value);
    }
}