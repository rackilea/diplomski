List<TaxLine> flattened = taxes.stream()
    .collect(Collectors.groupingBy(
        TaxLine::getTitle,
        Collectors.groupingBy(
            TaxLine::getRate,
            Collectors.reducing(
                BigDecimal.ZERO,
                TaxLine::getPrice,
                BigDecimal::add))))
    .entrySet()
    .stream()
    .flatMap(e1 -> e1.getValue()
         .entrySet()
         .stream()
         .map(e2 -> new TaxLine(e2.getValue(), e2.getKey(), e1.getKey())))
    .collect(Collectors.toList());