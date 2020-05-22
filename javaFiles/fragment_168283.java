static String doubleToPrice(double dbl,char currency) {
    Locale locale =null;
    if(currency=='€') {
    locale  = new Locale("fr", "FR");
    }else {
        locale  = new Locale("en", "EN");
    }//Add locales as per need.
    DecimalFormatSymbols sym = new DecimalFormatSymbols(locale);
    sym.setGroupingSeparator('.');
    DecimalFormat decimalFormat = (DecimalFormat)
            NumberFormat.getNumberInstance(locale);
    decimalFormat.applyPattern(currency+"##,###.00");
    decimalFormat.setDecimalFormatSymbols(sym);
    return decimalFormat.format(dbl);
}