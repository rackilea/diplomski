Map<String, List<Double>> map =
        // Get the list of companies
Observable.from(getCompaniesFromDB())
        // Use flat map with subscribeOn to make price lookup
        // asynchronous since it's an IO operation
        .flatMap(
                company -> Observable
                        .fromCallable(
                                () -> new CompanyNameAndPricesTuple(company, getStockPricesOfCompany(company)))
                            .subscribeOn(Schedulers.io()))
        // Create a map out of the tuples we've created
        .toMap(tuple -> tuple.companyName, tuple -> tuple.getPrices())
        // Get the map
        .toBlocking().first();