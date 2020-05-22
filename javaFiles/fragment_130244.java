public class CustomDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("MM/yy");
        String date = jp.getText();

        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }
}