if (n == 1) {
    System.out.println(a);
    return;
}
for (int i = n; i < a.length; i++) {
    if (a[i] == a[n-1])
        return;
}
for (int i = 0; i < n; i++) {
    boolean duplicate = false;
    for (int j = 0; !duplicate && j < i; j++)
        duplicate = a[i] == a[j];
    if (!duplicate) {
        swap(a, i, n-1);
        perm2(a, n-1);
        swap(a, i, n-1);
    }
}