private void sum() {
    int a[] = {2, 6, 1, 4};
    int b[] = {2, 1, 4, 4};

    int result[] = new int[a.length];
    Arrays.setAll(result, i -> a[i] + b[i]);
}