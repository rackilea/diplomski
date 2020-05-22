static Map<Integer, Map<Character, Float>> parse(String input) {
    if (! input.startsWith("{") || ! input.endsWith("}"))
        throw new IllegalArgumentException("Invalid input (missing surrounding '{}'): " + input);
    Map<Integer, Map<Character, Float>> output = new LinkedHashMap<>();

    Matcher m = Pattern.compile("\\G(\\d+)=\\{(.)=([0-9.]+)\\}(?:, |$)")
            .matcher(input).region(1, input.length() - 1);
    int end = 1;
    while (m.find()) {
        output.computeIfAbsent(Integer.valueOf(m.group(1)), k -> new LinkedHashMap<>())
                .put(m.group(2).charAt(0), Float.valueOf(m.group(3)));
        end = m.end();
    }
    if (end != input.length() - 1)
        throw new IllegalArgumentException("Invalid input at: " + input.substring(end));
    return output;
}