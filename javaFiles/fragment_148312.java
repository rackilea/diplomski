public static class CompanyNameAndPricesTuple {
    private final String companyName;
    private final List<Double> prices;

    public CompanyNameAndPricesTuple(String companyName, List<Double> prices) {
        this.companyName = companyName;
        this.prices = prices;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Double> getPrices() {
        return prices;
    }
}

//Dummy method for fetching the list of companies from the DB
public static List<String> getCompaniesFromDB() {
    return Arrays.asList("Google", "Apple", "Oracle", "Amazon");
}

//Dummy method for fetching the list of prices for a company
public static List<Double> getStockPricesOfCompany(String companyName) {
    try {
        Thread.sleep((long) (Math.random() * 100)); //Simulate an IO access to some external resource
    } catch (InterruptedException e) {
    }

    //A list of 100 random doubles, using Rx of course
    return Observable.fromCallable(() -> Math.random() * 1000).repeat(100).toList().toBlocking().first();
}