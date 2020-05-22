public class TimeZoneDeserializer implements JsonDeserializer<TimeZone> {

    @Override
    public TimeZone deserialize(
            JsonElement jsonElement,
            Type type,
            JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {
        String timezoneId = jsonElement
                .getAsJsonObject()
                .get("timeZoneId")
                .getAsString();

        return TimeZone.getTimeZone(timezoneId);
    }
}