class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.currentToken() == JsonToken.START_OBJECT) {
            MapType mapType = ctxt.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
            JsonDeserializer<Object> mapDeserializer = ctxt.findRootValueDeserializer(mapType);
            Map<String, Object> node = (Map<String, Object>) mapDeserializer.deserialize(p, ctxt);
            Map<String, Integer> date = (Map<String, Integer>) node.get("date");
            Map<String, Integer> time = (Map<String, Integer>) node.get("time");

            LocalDate localDate = LocalDate.of(date.get("year"), date.get("month"), date.get("day"));
            LocalTime localTime = LocalTime.of(time.get("hour"), time.get("minute"), time.get("second"), time.get("nano"));

            return LocalDateTime.of(localDate, localTime);
        } else if (p.currentToken() == JsonToken.VALUE_NUMBER_INT) {
            // You need to be really careful here. Date format is ambiguous
            // You should test it for all months and days
            String date = p.getValueAsString();
            // parse date string
            // ...

            return LocalDateTime.now();
        } else if (p.currentToken() == JsonToken.VALUE_NULL) {
            return null;
        }

        return null;
    }
}