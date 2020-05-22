public static String[] readWords(final String filename) {
    // Check on input
    if (filename == null) {
        return null;
    }
    String[] words = new String[0];
    int i = 0; // index of the first empty position in the array
    final File inputFile = new File(filename);
    try (Scanner in = new Scanner(inputFile)) {
        in.useDelimiter("\\s+|\\-");
        while (in.hasNext()) {
            String word = in.next().toLowerCase();
            word = word.replaceAll("[^a-z ]", ""); // No need of A-Z since we called .toLowerCase()
            words = Arrays.copyOf(words, words.length + 1);
            words[i++] = word; // Put the current word at the bottom of the array, then increment the index
        }
    } catch (final FileNotFoundException e) {
        System.err.println("The file " + filename + " does not exist");
        return null;
    }

    return words;
}