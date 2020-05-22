while (j > 3) {
        if (A[j - 1] > A[j]) {
            int temp = A[j];
            A[j] = A[j - 1];
            A[j - 1] = temp;         \
        }                             A[j - 1] loaded immediately after store
        if (A[j - 2] > A[j - 1]) {   /
            int temp = A[j - 1];
            A[j - 1] = A[j - 2];
            A[j - 2] = temp;         \
        }                             A[j - 2] loaded immediately after store
        if (A[j - 3] > A[j - 2]) {   /
            int temp = A[j - 2];
            A[j - 2] = A[j - 3];
            A[j - 3] = temp;         \
        }                             A[j - 3] loaded immediately after store
        if (A[j - 4] > A[j - 3]) {   /
            int temp = A[j - 3];
            A[j - 3] = A[j - 4];
            A[j - 4] = temp;
        }
        j -= 4;
    }