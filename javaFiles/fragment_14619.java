static int countSwaps(int... a) {
    int n0 = 0, i0 = 0, n1 = 0, i1 = 0;
    for (int p = 0; p < a.length; ++p) {
        if (a[p] == 0)
            n0 += p - i0++; // No. of steps to move the 0 to the left
        else
            n1 += p - i1++; // No. of steps to move the 1 to the left
    }
    return Math.min(n0, n1); // Choose lowest no. of steps
}