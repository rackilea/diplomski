static int hacko(int n) {

    // Shortcut for n=1, n=2 and n=3
    if (n < 4)
        return n;

    // Array to store the previous results
    int[] temp = new int[n];
    temp[0] = 1;
    temp[1] = 2;
    temp[2] = 3;

    // Iterative approach, more scalable, counts up
    for (int i = 3; i < n; i++) {
        temp[i] = 3 * temp[i - 3] + 2 * temp[i - 2] + temp[i - 1];
    }

    return temp[n - 1];

}