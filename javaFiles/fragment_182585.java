private static boolean isRightMoneyValue(double value, String currencyIso) {
    Locale locale = new Locale(currencyIso);
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    try {

        currencyFormatter.format(value);
    } catch (Exception e) {
        return false;
    }
    return true;
}