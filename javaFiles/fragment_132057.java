Currency dollar = Currency.getInstance("USD");
NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.GERMANY); //this gets € as currency symbol
BigDecimal monetaryAmount = BigDecimal.valueOf(12.34d);
String originalEuros = fmt.format(monetaryAmount);
System.out.println(originalEuros);

fmt.setCurrency(dollar);  // change the currency symbol to $
String modifiedDollars = fmt.format(monetaryAmount);
System.out.println(modifiedDollars);