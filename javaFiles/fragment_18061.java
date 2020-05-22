// Suggestion 2:
public static <T> T toObject2(final Class<T> type, final String json) throws IOException {
    return jsonMapper.readerFor(type).readValue(json);
}

// Suggestion 3:
public static <T> T toObject3(final Class<T> type, final String json) throws IOException {
    return jsonReader.forType(type).readValue(json);
}