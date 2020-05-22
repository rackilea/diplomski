static int solutionLoop(int n) {
    int max = 0;
    for (int i = n >>>= Integer.numberOfTrailingZeros(n), current = 0; i != 0; i >>>= 1) {
        if ((i & 1) == 0)
            ++current;
        else {
            max = Math.max(max, current);
            current = 0;
        }
    }
    return max;
}