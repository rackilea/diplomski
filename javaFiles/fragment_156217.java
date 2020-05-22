BigDecimal toFormat = BigDecimal.valueOf(10.55555);
System.out.println("Round down");
System.out.println(format.format(toFormat)); // 10.5555

format.setRoundingMode(RoundingMode.HALF_UP);
toFormat = BigDecimal.valueOf(10.55555);
System.out.println("Round up");
System.out.println(format.format(toFormat)); // 10.5556