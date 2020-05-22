public String toCsvRow() {
    return Stream.of(page, document, loan, type)
            .map(value -> value.replaceAll("\"", "\"\""))
            .map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
            .collect(Collectors.joining(","));
}