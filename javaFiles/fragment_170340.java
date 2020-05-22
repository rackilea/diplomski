BigDecimal TWENTY = BigDecimal.valueOf(20);
BigDecimal POINT9 = BigDecimal.valueOf(0.9);
BigDecimal reduce = 
             numbers.stream()
                    .filter(n -> n.compareTo(TWENTY) > 0)
                    .reduce(BigDecimal.ZERO, 
                           (a, b) -> a.add(b.multiply(POINT9)));