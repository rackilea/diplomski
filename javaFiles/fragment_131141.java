private static String commaSeparate(Iterable<?> items) {
    StringBuilder builder = new StringBuilder();
    for (Object item : items) {
        if (builder.length() != 0) {
            builder.append(", ");
        }
        builder.append(item);
    }
    return builder.toString();
}