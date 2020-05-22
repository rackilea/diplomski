float number = 12344.12f;

DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator('.');
symbols.setDecimalSeparator(','); // to be sure it is ','

DecimalFormat decimalFormat = new DecimalFormat();
decimalFormat.setDecimalFormatSymbols(symbols);
decimalFormat.setMaximumFractionDigits(2);

String format = decimalFormat.format(number);

System.out.println(format);