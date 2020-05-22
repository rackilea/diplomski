private void matchString(String s1, String s2) {
    int matchCount = 0;
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    // go through all characters in the match string
    for (char ch : s2.toCharArray()) {
        // look for the character in the first string
        if (s1.indexOf(ch) >= 0) {
            matchCount++;
        }
    }
    if (matchCount == s2.length()) {
        System.out.print("True");
    }
}