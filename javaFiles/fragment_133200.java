latestRatesFromDB().firstOrDefault(dummyValue)
    .concatWith(ratesFromNetwork())
    .distinct().skip(1)
    .subscribe(this::save, 
        System.err::println, 
        () -> System.out.println("completed"));