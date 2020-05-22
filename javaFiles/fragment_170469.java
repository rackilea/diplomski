public int letterScore(char letter) {
    final int LETTER_OFFSET = 9;
    int score = Character.getNumericValue(letter);
    score -= LETTER_OFFSET;
    return score;
}