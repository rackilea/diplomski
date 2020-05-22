public static int countOccurance (String word, String sentence) {
    int count = 0;
    for (int i = 0; i != sentence.length()-word.length(); i++) {
        if (sentence.substring(i, i+word.length()).equalsIgnoreCase(word)) {
            count++;
        }
    }
    return count;
}