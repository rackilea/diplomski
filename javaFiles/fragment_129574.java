private static String removeWord(String string, String word) {
    if (string.contains(word)) {
        String tempWord = word.trim();
        string = string.replaceAll(Pattern.quote(tempWord), "");
    }
    return string;
}