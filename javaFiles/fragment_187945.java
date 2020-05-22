static long IntersectDocumentsTime(AlgorithmInterface algorithm) {
    long start = System.nanoTime();
    algorithm.IntersectDocuments();
    long end = System.nanoTime();
    long durationInNanos = end - start;
    return durationInNanos;
}