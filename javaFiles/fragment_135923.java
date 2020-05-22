private int findBestExecutor() {
    // Thread index -> substream count mapping:
    final int[] loads = new int[streamThreads.length];
    for (int thread : threadById.values()) {
        ++loads[thread];
    }
    // return the index of the minimum load
    return IntStream.range(0, streamThreads.length)
            .reduce((i, j) -> loads[i] <= loads[j] ? i : j)
            .orElse(0);
}