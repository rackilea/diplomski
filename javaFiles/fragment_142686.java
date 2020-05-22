public static void splitAndConsumeWords(String line, Consumer<String> wordsConsumer) {

    char[] characters = line.toCharArray();
    StringBuilder sb = new StringBuilder(16);
    for (int index = 0; index < characters.length; index++) {
        char ch = characters[index];
        char replacementCh = ONLY_LETTERS_TO_LOWERCASE[ch];
        // If we encounter a space
        if (replacementCh == ' ') {
            // And there is a word in string builder
            if (sb.length() > 0) {
                // Send this word to the consumer
                wordsConsumer.accept(sb.toString());
                // Reset the string builder
                sb.setLength(0);
            }
        } else if (replacementCh != 0) {
            sb.append(replacementCh);
        }
    }
    // Send the last word to the consumer
    if (sb.length() > 0) {
        wordsConsumer.accept(sb.toString());
    }
}