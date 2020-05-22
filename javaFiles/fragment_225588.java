public int countLetters() {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
        if (Character.isLetter(word.charAt(i))) {
            count++;
        }
    }
    return count;
}