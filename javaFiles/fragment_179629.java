class LocalDateJsonDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.currentToken() == JsonToken.START_OBJECT) {
            MapType mapType = ctxt.getTypeFactory().constructMapType(Map.class, String.class, Integer.class);
            JsonDeserializer<Object> mapDeserializer = ctxt.findRootValueDeserializer(mapType);
            Map<String, Integer> date = (Map<String, Integer>) mapDeserializer.deserialize(p, ctxt);

            return LocalDate.of(date.get("year"), date.get("month"), date.get("day"));
        } else if (p.currentToken() == JsonToken.VALUE_NUMBER_INT) {
            // You need to be really careful here. Date format is ambiguous
            // You should test it for all months and days
            String date = p.getValueAsString();
            int year = Integer.parseInt(date.substring(0, 4));
            // much better to use always two digits for month: `03` instead `3`
            int month = Integer.parseInt(date.substring(4, 5));
            int day = Integer.parseInt(date.substring(5, 7));

            return LocalDate.of(year, month, day);
        } else if (p.currentToken() == JsonToken.VALUE_NULL) {
            return null;
        }

        return null;
    }
}