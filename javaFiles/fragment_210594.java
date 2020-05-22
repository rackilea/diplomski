private static <T> T fromJson(final String json, final Type type) {
    if ( type == null ) {
        return null;
    }
    return gson.fromJson(json, type);
}