String input = "1234567";
    String prepared = prepare(input);

    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.GERMAN);
    symbols.setDecimalSeparator(',');
    symbols.setGroupingSeparator('.');

    DecimalFormat format = new DecimalFormat("###,###.00");
    format.setDecimalFormatSymbols(symbols);
    format.setParseBigDecimal(true);

    BigDecimal bigDecimal = (BigDecimal)format.parse(prepared);
    String n = format.format(bigDecimal);

    System.out.println(n);