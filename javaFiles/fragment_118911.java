private BigDecimal calculateTax(String country, BigDecimal amount) throws Exception {
    if (taxRates.containsKey(country)) {
        return new BigDecimal(taxRates.get(country)).multiply(amount);
    } else {
        throw new Exception("Country not supported");
    }
}