public static int characterCount(char letter, String word) {
    int characterCount = 0;
    for (char c : word.toCharArray()) {
        if (c == letter) {
            characterCount++;
        }
    }
    return characterCount;
}