public class MyJsonDateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy"); // german date
        String d = jsonparser.getText();
        try {
            return f.parse(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}