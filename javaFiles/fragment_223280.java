public static List<List<String>> combine(List<String> fields) {
    return combine(fields, 0, new ArrayList<>());
}

public static List<List<String>> combine(List<String> fields,
                                         int start, List<String> prefix) {
    List<List<String>> combinations = new ArrayList<>();
    if (start >= fields.size()) {
        combinations.add(prefix);
        return combinations;
    }
    String field = fields.get(start);
    if (field.contains("false")) {
        combinations.addAll(combine(fields, start + 1, prefix));
    }
    List<String> prefixWithField = new ArrayList<>(prefix);
    prefixWithField.add(field);
    combinations.addAll(combine(fields, start + 1, prefixWithField));
    return combinations;
}