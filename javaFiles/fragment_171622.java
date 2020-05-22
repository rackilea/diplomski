public static String toString(Iterable<?> iterable) {
    StringJoiner joiner = new StringJoiner(", ");
    for (Object value : iterable)
        joiner.add(String.valueOf(value));
    return joiner.toString();
}