private void runTests3() {
    // output current locale we are running under
    System.out.println( "Current Locale is " + Locale.getDefault().toString() );

    // number in Central European Format with a format string specified in UK format
    String numbersInEuropeanFormatString[] = new String[] { "1.000,234567", "1,2345678", "1.222.333,234567" };
    String formatUK = "###,##0.0000";

    // output numbers using the german locale
    System.out.println("Output numbers using the German locale\n");
    for(String num : numbersInEuropeanFormatString ) {
        formatNumberAsDouble(num, formatUK, Locale.GERMAN);
    }

    // output numbers using the UK locale.  
    // this should return unexpected results as the number is in European format
    System.out.println("Output numbers using the UK locale\n");
    for(String num : numbersInEuropeanFormatString ) {
        formatNumberAsDouble(num, formatUK, Locale.UK);
    }

    // output numbers using new DecimalFormat( formatUK ) - no locale specified
    System.out.println("\n\nOutput numbers using new DecimalFormat( " + formatUK + " )\n");
    for(String num : numbersInEuropeanFormatString ) {
        formatNumberAsDouble( num, formatUK, null);
    }
}

private void formatNumberAsDouble(String value, String format, Locale locale) {


    NumberFormat formatter;
    int decimalPlaces;

    // create the formatter based on the specified locale
    if( locale != null ) {
         formatter = NumberFormat.getNumberInstance(locale);
         // creating the above number format does not take in the format string
         // so create a new one that we won't use at all just to get the
         // decimal places in it
         decimalPlaces = (new DecimalFormat(format)).getMaximumFractionDigits();
    } else {
        formatter = new DecimalFormat( format );
        decimalPlaces = formatter.getMaximumFractionDigits();
    }

    // get the result as number
    Double result = null;
    try {
        result = formatter.parse( value ).doubleValue();
    } catch( ParseException ex ) {
        // not bothered at minute
    }

    // round the Double to the precision specified in the format string


    BigDecimal bd = new BigDecimal(result );
    Double roundedValue = bd.setScale( decimalPlaces, RoundingMode.HALF_UP ).doubleValue();

    // output summary
    System.out.println("\tValue = " + value);
    System.out.println( locale == null  ? "\tLocale not specified" : "\tLocale = " + locale.toString());
    System.out.println( format == null || format.length() == 0 ? "\tFormat = Not specified" : "\tFormat = " + format);
    System.out.println("\tResult (Double) = " + result);
    System.out.println("\tRounded Result (Double) (" + decimalPlaces + "dp) = " + roundedValue);
    System.out.println("");
}