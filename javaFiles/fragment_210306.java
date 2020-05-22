public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> charPos = new HashMap<>();
    int start = 0, maxLen = 0;
    for (int idx = 0; idx < s.length(); idx++) {
        char ch = s.charAt(idx);
        Integer preIdx = charPos.get(ch);
        if (preIdx != null && preIdx >= start) { // found repeat
            if (idx - start > maxLen)
                maxLen = idx - start;
            start = preIdx + 1;
        }
        charPos.put(ch, idx);
    }
    return Math.max(maxLen, s.length() - start);
}