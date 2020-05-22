public class Currency {
    private final String symbol; 
    private final Set<ExchangeRate> rates = new HashSet<>();

    public Currency(String symbol) {
        this.symbol = symbol;
    }
    public BigDecimal convert(Currency currency, BigDecimal amount) {
        return findExchangeRate(currency).getRate().multiply(amount).setScale(2, RoundingMode.HALF_DOWN);
    }
    public String getSymbol() {
        return symbol;
    }
    public ExchangeRate findExchangeRate(Currency currency) {
        for(ExchangeRate rate: rates) {
            if ( rate.getCurrency().equals(currency)) {
                return rate;
            }
        }
        throw new IllegalArgumentException("Currency not found: " + currency);
    }
    public void setExchangeRate(ExchangeRate rate) {
        if ( rates.contains(rate) ) rates.remove(rate);
        rates.add(rate);
    }
    public boolean removeExchangeRate(ExchangeRate rate) {
        return rates.remove(rate);
    }