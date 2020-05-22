public class LocalDateDeserializer extends JsonDeserializer<LocalDate>{

  @Override
  public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("required format");

      LocalDate localDate = null;
      localDate = LocalDate.parse(p.getText(), formatter);

      return localDate;
  }
}