public static int countWordsInUnsorted(final String searchedWord, final String[] words) {
    // Check on input
    if ((searchedWord == null) || (words == null)) {
        return 0;
    }

    int count = 0;
    for (final String word : words) {
        if (word.equals(searchedWord)) {
            count++;
        }
    }
    return count;
}