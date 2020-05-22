int count = 0;
final String prefix = "tissue";

try (BufferedReader br = new BufferedReader(new StringReader("tissue2 tiss tiss3 tissue3"))) {
    String line;
    while ((line = br.readLine()) != null) {
        // Get all the words on this line
        final String[] wordsInLine = line.split(" ");

        for (final String s : wordsInLine) {
            // Check that the word starts with the prefix.
            if (s.startsWith(prefix)) {
                count++;
            }
        }

    }
    System.out.println(count);
} catch (final IOException ignored) {
}