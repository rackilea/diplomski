DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);

DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
symbols.setGroupingSeparator('\u2008');

formatter.setDecimalFormatSymbols(symbols);

Log.e("Formatted: ", formatter.format(1241234));