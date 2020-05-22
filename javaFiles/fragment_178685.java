private static int nGroup(final int numOfOccs, final int elem, final int[] whereToFind) {
    if(numOfOccs == 0 || whereToFind == null) {
        return 0;
    }

    int res = 0;
    int streakLength = 0;
    for (final int i : whereToFind) {
        if (elem != i) {
            streakLength = 0;
        } else if (++streakLength >= numOfOccs) {
            res++;
        }
    }

    return res;
}