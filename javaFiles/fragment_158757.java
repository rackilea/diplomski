public static String longestWord(String s) {        
    return longestWord(s.split(" "), 0, 0);
}

public static String longestWord(String[] words, int currentIdx, int longestIdx) {
    if (currentIdx == words.length)
        return words[longestIdx];
    int idx;  // temporarily stores the index of the current longest word
    if (words[currentIdx].length() > words[longestIdx].length())
        idx = currentIdx;
    else
        idx = longestIdx;
    return longestWord(words, currentIdx + 1, idx);
}