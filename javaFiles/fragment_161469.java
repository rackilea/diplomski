Map<String,Map<Integer,BigDecimal>> totals = 
    cars.stream ()
        .collect (Collectors.groupingBy (c->c.make,
                                         Collectors.groupingBy (c->c.year,
                                                                Collectors.reducing (new BigDecimal(0),
                                                                                     c->c.amount,
                                                                                     BigDecimal::add))));