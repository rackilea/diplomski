public class LocalDateJsonDeserializer implements JsonDeserializer<LocalDate> {    
      public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
          throws JsonParseException {
        return new LocalDate(json.getAsJsonPrimitive().getAsString());
      }
}