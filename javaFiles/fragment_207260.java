Locale locale = Locale.UK;
  Currency curr = Currency.getInstance(locale);

  // get and print the symbol of the currency
  String symbol = curr.getSymbol(locale);
  System.out.println("Symbol is = " + symbol);