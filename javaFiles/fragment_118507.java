DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

symbols.setGroupingSeparator(' ');
formatter.setDecimalFormatSymbols(symbols);
System.out.println(formatter.format(bd.longValue()));