private static void printLetterCounts(String text) {
    int[] letterCount = new int[26];
    for (char c : text.toCharArray())
        if (c >= 'a' && c <= 'z')
            letterCount[c - 'a']++;
        else if (c >= 'A' && c <= 'Z')
            letterCount[c - 'A']++;
    for (int i = 0; i < 26; i++)
        if (letterCount[i] > 0) {
            char[] stars = new char[letterCount[i]];
            Arrays.fill(stars, '*');
            System.out.println((char)('a' + i) + ":" + new String(stars));
        }
}