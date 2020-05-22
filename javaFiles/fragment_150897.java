DecimalFormat decimalFormat = new DecimalFormat();
DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator(' ');
decimalFormat.setDecimalFormatSymbols(symbols);
double number = decimalFormat.parse(input).doubleValue();
System.out.println(number);