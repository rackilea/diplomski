public class MapEntryDeserializer implements JsonDeserializer<Map.Entry<Long, String>> {

    /**
     * Pattern corresponding to:
     * Starts with [
     * <a non empty sequence of digit characters>,
     * <a non empty sequence of any characters
     * Ends with ]
     */
    private static final Pattern PATTERN = Pattern.compile("^\\[(\\d+), ?(.+)\\]$");

    public Map.Entry<Long, String> deserialize(JsonElement json, Type typeOfT, 
        JsonDeserializationContext context) throws JsonParseException {
        // Extract the key/value pair from Strings of type [3, rabbit]
        String value = json.getAsString();
        Matcher matcher = PATTERN.matcher(value);
        if (!matcher.find()) {
            throw new JsonParseException(
                String.format("The map entry doesn't have the expected format: %s", value)
            );
        }
        return new AbstractMap.SimpleEntry<>(
            Long.valueOf(matcher.group(1)), matcher.group(2)
        );
    }
}