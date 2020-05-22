static BigDecimal roundVaros(BigDecimal value, BigDecimal x, BigDecimal y) {
    BigDecimal a = value.divide(x, RoundingMode.HALF_UP);
    BigDecimal b = y.divide(x, RoundingMode.HALF_UP);

    a = a.subtract(BigDecimal.valueOf(a.longValue()));
    b = b.subtract(BigDecimal.valueOf(b.longValue()));

    if (a.compareTo(b) >= 0) {
        return value.divide(x, RoundingMode.HALF_UP).setScale(0, RoundingMode.CEILING).multiply(x);
    } else {
        return value.divide(x, RoundingMode.HALF_UP).setScale(0, RoundingMode.FLOOR).multiply(x);
    }
}