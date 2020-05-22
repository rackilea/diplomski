for (int i = gap; i < a.length; i++) {
    int tmp = a[i];
    int j = i;
    for (; j >= gap && tmp < (a[j - gap]); j -= gap) {
        a[j] = a[j - gap];
    }
    a[j] = tmp;
}