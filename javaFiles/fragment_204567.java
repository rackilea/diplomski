public boolean scoresIncreasing(int[] scores) {
    boolean result = true; // assume true
    for (int i = 0; i < scores.length-1; i++) // fix loop end
    {
        if (scores[i] > scores[(i + 1)]) return false;
    } // missing brace
    return result;
}