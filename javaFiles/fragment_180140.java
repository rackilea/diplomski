public class LabelsDeserializer implements JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(
            final JsonElement json,
            final Type typeOfT,
            final JsonDeserializationContext context) {
        // Check if the JSON object is an array or a primitive value
        if (json.isJsonArray()) {
            // Multiple Strings elements
            final JsonArray jsonArray = json.getAsJsonArray();
            final List<String> labels = new ArrayList<>(jsonArray.size());

            for (final JsonElement jsonElement : jsonArray) {
                labels.add(jsonElement.getAsString());
            }

            return labels;
        }

        // Single String element
        return Collections.singletonList(json.getAsString());
    }
}