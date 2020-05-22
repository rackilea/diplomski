DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator('.');
symbols.setDecimalSeparator(','); // to be sure it is ','

DecimalFormat decimalFormat = new DecimalFormat("#.###.00");
decimalFormat.setDecimalFormatSymbols(symbols);

String format = decimalFormat.format(number);