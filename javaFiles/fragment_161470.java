Map<String,Map<Integer,BigDecimal>> totals = 
    cars.stream ()
        .collect (Collectors.groupingBy (Car::getMake,
                                         Collectors.groupingBy (Car::getYear,
                                                                Collectors.reducing (new BigDecimal(0),
                                                                                     Car::getAmount,
                                                                                     BigDecimal::add))));