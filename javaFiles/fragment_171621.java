public static String listToString(List<?> list) {
    StringBuilder buf = new StringBuilder();
    boolean first = true;
    for (Object value : list) {
        if (first)
            first = false;
        else
            buf.append(", ");
        buf.append(value);
    }
    return buf.toString();
}