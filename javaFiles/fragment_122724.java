String input = NumberFormat.getNumberInstance(Locale.FRANCE).format(123123123);
System.out.println("String after conversion in locale "+input);

DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.FRANCE);
DecimalFormatSymbols symbols = df.getDecimalFormatSymbols();
char thousandSep = symbols.getGroupingSeparator();

input = input.replace(thousandSep, '.');