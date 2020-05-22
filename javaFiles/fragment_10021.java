int determineNextSize(String input, int size) {
    int minSize = -1;
    int p0 = 0;
    while (p0 < innput.length()) {
        int p = input.indexOf(' ', p0);
        if (p == -1) {
            p = input.length();
        }
        int wordSize = p - p0;
        if (wordSize  > size && (minSize == -1 || wordSize  < minSize)) {
            minSize = wordSize ;
        }
        p0 = p + 1;
    }
    return minSize;
}

void collectUniqueWordsOfLength(String input, int size, StringBuilder words) {
    int p0 = 0;
    while (p0 < innput.length()) {
        int p = input.indexOf(' ', p0);
        if (p == -1) {
            p = input.length();
        }
        int wordSize = p - p0;
        if (wordSize  == size)) {
            String word = input.substring(p0, p) + " ";
            if (!words.toString().contains(word)) {
                words.append(word);
            }
        }
        p0 = p + 1;
    }
}