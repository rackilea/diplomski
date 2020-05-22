public int[] loop() {
    int[] a = new int[100];
    for (int i = 0; i < 100; ++i) {
        a[i] = i;
    }
    return a;
}

public int[] guava() {
    Set<Integer> set = ContiguousSet.create(Range.closed(0, 99), DiscreteDomains.integers());
    int[] a = Ints.toArray(set);
    return a;
}