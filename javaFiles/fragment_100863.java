public Map<String, Integer> findTheWords(String stringToCheck, List<String> words) {
    Pattern regexp = Pattern.compile(words.stream().distinct().map(word -> "\\b" + word + "\\b").collect(Collectors.joining("|")));
    // creates a pattern like this: "\ba\b|\bb\b|\bc\b|\bd\b|\be\b"
    Matcher matcher = regexp.matcher(stringToCheck);
    Map<String, Integer> result = new HashMap<>();
    while (matcher.find()) {
        String word = matcher.group();
        result.put(word, result.getOrDefault(word, 0) + 1);
    }
    return result;
}