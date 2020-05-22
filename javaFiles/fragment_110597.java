public static void parallelSort(long[] a, int fromIndex, int toIndex) {
    rangeCheck(a.length, fromIndex, toIndex);
    int n = toIndex - fromIndex, p, g;
    if (n <= MIN_ARRAY_SORT_GRAN ||
        (p = ForkJoinPool.getCommonPoolParallelism()) == 1)
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, null, 0, 0);
    else
        new ArraysParallelSortHelpers.FJLong.Sorter
            (null, a, new long[n], fromIndex, n, 0,
             ((g = n / (p << 2)) <= MIN_ARRAY_SORT_GRAN) ?
             MIN_ARRAY_SORT_GRAN : g).invoke();
}

public static void parallelSort(float[] a, int fromIndex, int toIndex) {
    rangeCheck(a.length, fromIndex, toIndex);
    int n = toIndex - fromIndex, p, g;
    if (n <= MIN_ARRAY_SORT_GRAN ||
        (p = ForkJoinPool.getCommonPoolParallelism()) == 1)
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, null, 0, 0);  // 1
    else
        new ArraysParallelSortHelpers.FJFloat.Sorter                     // 2
            (null, a, new float[n], fromIndex, n, 0,                     // 3
             ((g = n / (p << 2)) <= MIN_ARRAY_SORT_GRAN) ?
             MIN_ARRAY_SORT_GRAN : g).invoke();
}