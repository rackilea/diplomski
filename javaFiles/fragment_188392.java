public static int countWords(String str) {
    char[] sentence = str.toCharArray();
    boolean inWord = false;
    int wordCt = 0;
    for (char c : sentence) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            if (!inWord) {
                wordCt++;
                inWord = true;
            }
        } else {
            inWord = false;
        }
    }
    return wordCt;
}