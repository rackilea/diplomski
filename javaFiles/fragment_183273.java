private static final TypeToken<Response<Rate>> currencyRatesResponseTypeToken = new TypeToken<Response<Rate>>() {
};

private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(Date.class, getDateJsonDeserializer())
        .registerTypeAdapter(Rate.class, getRateJsonDeserializer())
        .create();

public static void main(final String... args) {
    final Response<Rate> response = gson.fromJson(JSON, currencyRatesResponseTypeToken.getType());
    System.out.println(response.page + "/" + response.pages + " (" + response.total + ")");
    for ( final Rate rate : response.rows ) {
        System.out.println(rate.created);
        for ( final Entry<String, Currency> entry : rate.currencies.entrySet() ) {
            final Currency currency = entry.getValue();
            System.out.println("* " + entry.getKey() + " <== " + currency.currency + " (" + currency.rateBuy + "/" + currency.rateSell + ") " + currency.created);
        }
    }
}