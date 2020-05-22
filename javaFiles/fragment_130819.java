// changed input amount to big decimal to avoid floating point issues
public BigDecimal convertTo(String from, String to, BigDecimal value) {

    // changed to validate the currency code - note BRA will fail - need to change to BRL - remove this code if you dont need it.
    Currency fromCurr = Currency.getInstance(from);
    Currency toCurr = Currency.getInstance(to);

    // debugging code - to help troubleshoot (only use this on small table) - will print out the contents of the table so you can see if data is not correct
    List<Rate> rates = em.createQuery("SELECT c FROM Rate c", Rate.class).getResultList();
    if (rates == null || rates.isEmpty()) {
        throw new RuntimeException("rates table is empty");
    }

    for (Rate r : rates) {
        // push to sysout or whatever logger you are using
        System.out.println(String.format("Rate:fromCur[%s], toCur[%s]", r.getFromCur(), r.getToCur()));
    }
    // end debugging code - remove when no longer needed.

    // changed the query to use bind parameters - :fromCurrency, :toCurrency
    TypedQuery<Rate> query = em.createQuery(
            "SELECT c FROM Rate c WHERE c.fromCur = :fromCurrency AND c.toCur = :toCurrency", Rate.class);

    query.setParameter("fromCurrency", fromCurr.getCurrencyCode());
    query.setParameter("toCurrency", toCurr.getCurrencyCode());

    Rate rate = query.getSingleResult();
    if (rate == null) {
        throw new EntityNotFoundException("Can't find rate");
    }

    // changed to use big decimal, scale and rounding as well as avoid floating point issues
    BigDecimal converted =
            value.multiply(rate.getValue()).setScale(toCurr.getDefaultFractionDigits(), RoundingMode.HALF_DOWN);

    return converted;
}