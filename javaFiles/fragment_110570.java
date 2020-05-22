try {
    new JsonParser().parse(jsonSource);
    // Valid.
} catch (JsonParseException e) {
    // Invalid.
}