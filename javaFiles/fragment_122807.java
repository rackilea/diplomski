AmountFormatQuery formatQuery = AmountFormatQueryBuilder.of(Locale.US)
    .set(CurrencyStyle.SYMBOL)
    .build();
MonetaryAmountFormat format = MonetaryFormats.getAmountFormat(formatQuery);
MonetaryAmount amount1 = format.parse("USD 1.23");
MonetaryAmount amount2 = format.parse("$3.45");