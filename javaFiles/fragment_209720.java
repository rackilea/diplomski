int sumTo(int[] ar, int to) {
    int i;
    for (i = 0; i < to; i += 2) {
        if (i == to - 1)
            ar[i / 2] = ar[i];
        else
            ar[i / 2] = ar[i] + ar[i + 1];
        }
    return (i + 1) / 2;
}