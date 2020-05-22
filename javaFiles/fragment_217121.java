for (int j = 2; j < n; ++j) {
    int key = A[j];
    int i = j - 1;

    while (i > 0 && A[i] > key) {
        A[i+1] = A[i];
        i = i - 1;  // can be replaced with '--i'
    }
    A[i + 1] = key
}