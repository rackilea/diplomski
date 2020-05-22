private boolean allWordsAreInEachLine(String[] words, String[] lines) {
    for (String line : lines) {
        if (!allWordsAreInLine(words, line)) {
            return false;
        }
    }
    return true;
}

private boolean allWordsAreInLine(String[] words, String line) {
    for (String word : words) {
        if (!line.contains(word)) {
            return false;
        }
    }
    return true;
}