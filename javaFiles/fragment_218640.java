...
DecimalFormat df =
    (DecimalFormat)NumberFormat.getNumberInstance(locale);
DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);

// These must be literalized to avoid collision with regex
// metacharacters such as dot or parenthesis
groupSeparator =   "\\" + dfs.getGroupingSeparator();
decimalSeparator = "\\" + dfs.getDecimalSeparator();
...