public String toJson(Object src) {
    if (src == null) {
        return toJson(JsonNull.INSTANCE);
    }
    return toJson(src, src.getClass());
}