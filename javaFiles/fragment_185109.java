private static List<String> rowsAsString(List<?> rows) {
    if (rows == null || rows.isEmpty())
        return Collections.emptyList();

    List<String> strings = new ArrayList<>(rows.size());
    for (Object row : rows) {
        strings.add(asString(row));
    }
    return strings;
}