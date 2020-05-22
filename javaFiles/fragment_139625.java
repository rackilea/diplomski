private static void language(final int n, final String[] syllables, final String currentWord) { // example of N = 3
    if (n == 0) {
        System.out.println(currentWord);
    } else {
        for (int i = 0; i < syllables.length; i++) {
            language(n - 1, syllables, currentWord + syllables[i]);
        }
    }
}