final class DateJsonDeserializer
        implements JsonDeserializer<Date> {

    // No state? So it can be a singleton
    private static final JsonDeserializer<Date> dateJsonDeserializer = new DateJsonDeserializer();

    private DateJsonDeserializer() {
    }

    // But not letting client code know if it's a singleton or not -- it's encapsulated
    static JsonDeserializer<Date> getDateJsonDeserializer() {
        return dateJsonDeserializer;
    }

    @Override
    public Date deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        // jsonElement.getAsLong() would work either
        // But even longs can have their own deserialization strategy
        // Note `* 1000` -- `java.util.Date` accepts milliseconds while Unix epoch is "seconds-based"
        return new Date((Long) context.deserialize(jsonElement, long.class) * 1000);
    }

}