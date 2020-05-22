public static int usdToCents(BigDecimal usd) {
    if (usd.scale() > 2) //more than 2dp
       thrown new InvalidUsdException(usd);// because was not supplied a billable USD amount
    BigDecimal bigDecimalInCents = usd.movePointRight(2);
    int cents = bigDecimalInCents.intValueExact();
    return cents;
}