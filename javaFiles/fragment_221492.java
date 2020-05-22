@Override
public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    try {
        if (typeOfT == LocalDate.class) {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_DATE);
        }
    } catch (DateTimeParseException e) {
        throw new JsonParseException(e);
    }
    throw new IllegalArgumentException("unknown type: " + typeOfT);
}