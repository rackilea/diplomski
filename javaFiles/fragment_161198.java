public String serializeArray(final String[] data) {
    return Arrays.stream(data)
            .map(s -> s.replace(",", "\\,"))
            .collect(joining(","));
}

public String[] deserializeArray(final String data) {
    return Pattern.compile("(?<!\\\\),").splitAsStream(data)
            .map(s -> s.replace("\\,", ","))
            .toArray(String[]::new);
}