public boolean scoresIncreasing(int[] scores) {
    boolean result;
    for (int i = 0; i < scores.length-1; i++) // fix loop end
    {
        if (scores[i] < scores[(i + 1)]) {
            result = true;
        }
        else {
            result = false;
            break;
        }
    } // missing brace
    return result;
}