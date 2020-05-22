public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> charPos = new HashMap<>();
    List<String> candidates = new ArrayList<>();
    int start = 0, maxLen = 0;
    for (int idx = 0; idx < s.length(); idx++) {
        char ch = s.charAt(idx);
        Integer preIdx = charPos.get(ch);
        if (preIdx != null && preIdx >= start) { // found repeat
            if (idx - start > maxLen) {
                candidates.clear();
                maxLen = idx - start;
            }
            if (idx - start == maxLen)
                candidates.add(s.substring(start, idx));
            start = preIdx + 1;
        }
        charPos.put(ch, idx);
    }
    if (s.length() - start > maxLen)
        maxLen = s.length() - start;
    if (s.length() - start == maxLen)
        candidates.add(s.substring(start));
    System.out.print(candidates + ": ");
    return maxLen;
}