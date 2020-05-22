// Any Java version
BigDecimal cashTotal = totals.get(PaymentType.CASH);
if (cashTotal == null)
    cashTotal = BigDecimal.ZERO;

// Java 8+
BigDecimal cashTotal = totals.getOrDefault(PaymentType.CASH, BigDecimal.ZERO);