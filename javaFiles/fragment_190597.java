void processSubWords(String word) {
    if (word.length() > 1) {
        for (int i = 1; i < word.length(); i++) {
            final String left = word.substring(0, i);
            final String right = word.substring(i);
            lookupAndUpdate(left);
            lookupAndUpdate(right);
        }
    }
}