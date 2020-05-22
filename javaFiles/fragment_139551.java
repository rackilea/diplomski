while (j > 3) {
        if (A[j - 1] > A[j]) {
            int temp = A[j - 1];
            A[j - 1] = A[j];
            A[j] = temp;         <-- another store instruction between A[j - 1] access
        }
        if (A[j - 2] > A[j - 1]) {
            int temp = A[j - 2];
            A[j - 2] = A[j - 1];
            A[j - 1] = temp;
        }
        ...