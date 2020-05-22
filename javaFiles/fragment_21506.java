for (int i = 0; i < mid; i++) {
    left[i] = A[i];
}

for (int i = mid; i < n; i++) {
    right[i - mid] = A[i];
}