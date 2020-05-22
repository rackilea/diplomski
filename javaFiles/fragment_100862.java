public Map<String, Integer> findTheWords(String stringToCheck, List<String> words) {
    return words.stream().distinct()
            .collect(Collectors.toMap(Function.identity(), word -> findTheWord(stringToCheck, word)));
}

public Integer findTheWord(String stringToCheck, String regexString) {
    Pattern regexp = Pattern.compile("\\b" + regexString + "\\b");
    Matcher matcher = regexp.matcher(stringToCheck);

    int count = 0;
    while (matcher.find()) {
        count++;
    }
    return count;
}