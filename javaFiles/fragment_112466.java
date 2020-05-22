public static String replaceString(double value){
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    String currencySymbol = formatter.getCurrency().getSymbol();
    String moneyString = formatter.format(value);
    return moneyString.replace(currencySymbol, "");
}

public static String convert(double x){
    return replaceString(x);
}