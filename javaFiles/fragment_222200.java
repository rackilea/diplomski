private static final String letters = "abcdefghijklmnopqrstuvwxyz";

public static String generateRandomString(int lower, int upper, int count) {
    final List<StringBuilder> randomWords = new ArrayList<>(count);
    final Random random = new Random();
    final int range = upper - lower + 1;

    while (--count >= 0) {
        int wordLength = lower + random.nextInt(range);
        final StringBuilder word = new StringBuilder(wordLength);

        while (--wordLength >= 0) {
            word.append(letters.charAt(random.nextInt(letters.length())));
        }
        randomWords.add(word);
    }
    return randomWords.toString();
}