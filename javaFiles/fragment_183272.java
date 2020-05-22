final class RateJsonDeserializer
        implements JsonDeserializer<Rate> {

    private static final JsonDeserializer<Rate> rateJsonDeserializer = new RateJsonDeserializer();

    private RateJsonDeserializer() {
    }

    static JsonDeserializer<Rate> getRateJsonDeserializer() {
        return rateJsonDeserializer;
    }

    @Override
    public Rate deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        boolean rateContext = false;
        Date rateCreated = null;
        final Map<String, Currency> rateCurrencies = new LinkedHashMap<>();
        // Analyzing rate JSON documents for each key/value pair
        for ( final Entry<String, JsonElement> entry : jsonObject.entrySet() ) {
            final String key = entry.getKey();
            final JsonElement value = entry.getValue();
            switch ( key ) {
            case "context":
                rateContext = context.deserialize(value, boolean.class);
                break;
            case "created":
                rateCreated = context.deserialize(value, Date.class);
                break;
            default:
                rateCurrencies.put(key, context.deserialize(value, Currency.class));
                break;
            }
        }
        // So that we can "unwrap" its layout and "flatten" the currencies map
        return new Rate(rateContext, rateCreated, rateCurrencies);
    }

}