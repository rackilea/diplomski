class LocalDateWithStringsDeserializer extends LocalDateDeserializer {

    private static final long serialVersionUID = 1L;

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        // [yyyy,mm,dd] or ["yyyy","mm","dd"]
        if (jp.isExpectedStartArrayToken()) {
            return parseArray(jp, ctxt);
        }

        return super.deserialize(jp, ctxt);
    }

    private LocalDate parseArray(JsonParser jp, DeserializationContext ctxt)
            throws JsonParseException, IOException {
        int year = getNextValue(jp);
        int month = getNextValue(jp);
        int day = getNextValue(jp);
        if (jp.nextToken() != JsonToken.END_ARRAY) {
            throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "after LocalDate ints");
        }
        return new LocalDate(year, month, day);
    }

    private int getNextValue(JsonParser jp) throws IOException, JsonParseException {
        jp.nextToken();

        return new Integer(jp.getText());
    }
}