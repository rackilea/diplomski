double bestProbability = -1;
double bestP1 = 0, bestP2 = 0;
for (Future<ProbabilityResult> future : futures) {
    ProbabilityResult result = future.get();
    if (result.getProbability() > bestProbability) {
        bestProbability = result.getProbability();
        bestP1 = result.getP1();
        bestP2 = result.getP2();
    }
}