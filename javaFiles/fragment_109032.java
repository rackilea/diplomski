public String format(Locale locale, Float value) {

    String sCurSymbol = "";
    boolean bPre = true;
    int ndx = 0;

    NumberFormat cfLocal = NumberFormat.getCurrencyInstance(locale);
    if (cfLocal instanceof DecimalFormat) { // determine if symbol is prefix or suffix
        DecimalFormatSymbols dfs =
                ((DecimalFormat) cfLocal).getDecimalFormatSymbols();
        sCurSymbol = dfs.getCurrencySymbol();
        String sLP = ((DecimalFormat) cfLocal).toLocalizedPattern();


        // here's how we tell where the symbol goes.
        ndx = sLP.indexOf('\u00A4');  // currency sign

        if (ndx > 0) {
            bPre = false;
        } else {
            bPre = true;
        }

        return cfLocal.format(value);

    }
    return "???";
}