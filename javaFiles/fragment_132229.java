final Map<String, BigDecimal> orderTotalsByCurrency = orderTotals.stream()
    .collect(Collectors.groupingBy(
        MoneyAmount::getCurrencyCode,    // String currencyCode is the key
        Collectors.reducing(             // Reducing value List<BigDecimal> to BigDecimal
            BigDecimal.ZERO,             // Identity
            MoneyAmount::getAmount,      // Mapper (geting the amount to sum)
            BigDecimal::add)));          // Operator (action to 2 subsequent values)