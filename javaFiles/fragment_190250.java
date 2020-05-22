public int matchCount(char[] text, char[] pattern) {
    int consecCharHits = 0, matchCount = 0;

    for (int i = 0; i < text.length; i++) {
        if (text[i] == pattern[consecCharHits] || '?' == pattern[consecCharHits]) { // if char matches
            consecCharHits++;
            if (consecCharHits == pattern.length) { // if the whole pattern matches
                matchCount++;
                i -= consecCharHits - 1; // return to the next position to be evaluated
                consecCharHits = 0; // reset consecutive char hits
            }
        } else {
            i -= consecCharHits;
            consecCharHits = 0;
        }
    }
    return matchCount;
}