BigDecimal money = new BigDecimal("1234567");

    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.GERMAN);
    symbols.setDecimalSeparator(',');
    symbols.setGroupingSeparator('.');

    // https://docs.oracle.com/javase/8/docs/api/java/text/DecimalFormat.html
    DecimalFormat format = new DecimalFormat("###,###.00");
    format.setDecimalFormatSymbols(symbols);

    System.out.println(format.format(money));