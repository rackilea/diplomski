private KnapsackItem computeBestItemForMinVal(
        final ArrayList<KnapsackItem> list, final int minVal) {
    int[] best = new int[minVal + 1];
    prioSum.clear();
    for (int w = 1; w <= minVal; w++) {
...