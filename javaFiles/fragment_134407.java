@Benchmark
public void testModified(Blackhole bh) {
    final double[] scores = sampleData;
    int[] candidates = new int[numberNeighbours];
    for (int i = 0; i < numberNeighbours; i++) {
        candidates[i] = i;
    }
    // sorting candidates so scores[candidates[0]] is the largest
    for (int i = 0; i < numberNeighbours; i++) {
        for (int j = i+1; j < numberNeighbours; j++) {
            if (scores[candidates[i]] < scores[candidates[j]]) {
                int temp = candidates[i];
                candidates[i] = candidates[j];
                candidates[j] = temp;
            }
        }
    }
    // processing other scores, while keeping candidates array sorted in the descending order
    for (int i = numberNeighbours; i < numberExamples; i++) {
        if (scores[i] > scores[candidates[0]]) {
            continue;
        }
        // moving all larger candidates to the left, to keep the array sorted
        int j; // here the branch prediction should kick-in
        for (j = 1; j < numberNeighbours && scores[i] < scores[candidates[j]]; j++) {
            candidates[j - 1] = candidates[j];
        }
        // inserting the new item
        candidates[j - 1] = i;
    }
    bh.consume(candidates);
}