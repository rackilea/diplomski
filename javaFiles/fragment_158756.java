public static String longestWord(String s) {
    return longestWord(s.split("\\s+"), 0, 0);
}

public static String longestWord(String[] words, int currentIdx, int longestIdx) {
    if (currentIdx == words.length)
        return words[longestIdx];
    return longestWord(words, currentIdx + 1,
        words[currentIdx].length() > words[longestIdx].length() ? currentIdx : longestIdx);
}