final BigDecimal coinRateInUSDWalletTo = new BigDecimal("14819.79865821543");
final BigDecimal result = BigDecimal.ONE.divide(
    coinRateInUSDWalletTo,
    10 /* Scale */,
    RoundingMode.HALF_UP
);