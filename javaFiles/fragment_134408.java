@Benchmark
public void testQuickSelect(Blackhole bh) {
    final int[] candidates = new int[sampleData.length];
    for (int i = 0; i < candidates.length; i++) {
        candidates[i] = i;
    }
    final int[] resultIndices = new int[numberNeighbours];
    int neighboursToAdd = numberNeighbours;

    int left = 0;
    int right = candidates.length - 1;
    while (neighboursToAdd > 0) {
        int partitionIndex = partition(candidates, left, right);
        int smallerItemsPartitioned = partitionIndex - left;
        if (smallerItemsPartitioned <= neighboursToAdd) {
            while (left < partitionIndex) {
                resultIndices[numberNeighbours - neighboursToAdd--] = candidates[left++];
            }
        } else {
            right = partitionIndex - 1;
        }
    }
    bh.consume(resultIndices);
}

private int partition(int[] locations, int left, int right) {
    final int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
    final double pivotValue = sampleData[locations[pivotIndex]];
    int storeIndex = left;
    for (int i = left; i <= right; i++) {
        if (sampleData[locations[i]] <= pivotValue) {
            final int temp = locations[storeIndex];
            locations[storeIndex] = locations[i];
            locations[i] = temp;

            storeIndex++;
        }
    }
    return storeIndex;
}