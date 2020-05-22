final class Rate {

    final boolean context;
    final Date created;
    final Map<String, Currency> currencies;

    Rate(final boolean context, final Date created, final Map<String, Currency> currencies) {
        this.context = context;
        this.created = created;
        this.currencies = currencies;
    }

}