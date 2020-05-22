float value;
    DecimalFormat df = new DecimalFormat();
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator(',');
    df.setDecimalFormatSymbols(symbols);
    try {
        Number n = df.parse("1,234");
        value = n.floatValue();            
    } catch (ParseException e) {
        e.printStackTrace();
    }