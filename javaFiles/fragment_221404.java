final BigDecimal price = BigDecimal.valueOf(215).setScale(6, BigDecimal.ROUND_HALF_EVEN);
final BigDecimal daysOfThisReservation = BigDecimal.valueOf(3).setScale(6, BigDecimal.ROUND_HALF_EVEN);

final BigDecimal dayPrice = price.divide(daysOfThisReservation, BigDecimal.ROUND_HALF_EVEN).setScale(6, BigDecimal.ROUND_HALF_EVEN);

System.out.println(dayPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN));
System.out.println(dayPrice.multiply(daysOfThisReservation).setScale(2, BigDecimal.ROUND_HALF_EVEN)); //215.01