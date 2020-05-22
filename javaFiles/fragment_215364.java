private static String randomWord;

private static void setUpDictionary() throws IOException {
    // ...
    randomWord = words[rand];
    // ...
}

private static String getWord() {
    return randomWord;
}