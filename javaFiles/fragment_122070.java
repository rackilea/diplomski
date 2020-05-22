DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setGroupingSeparator('_');
    symbols.setGroupingUsed(true);

    DecimalFormat df = new DecimalFormat("#######", symbols);
    df.setGroupingSize(3);

    String out = df.format(1234567);