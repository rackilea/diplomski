private static Pair<Integer, Integer> findClosestSum(List<Integer> X, List<Integer> Y, int target) {
    double bestDifference = Integer.MAX_VALUE;
    Pair<Integer, Integer> bestPair = null;
    int xIndex = 0;
    int yIndex = Y.size() - 1;

    while (true) {
        double sum = X.get(xIndex) + Y.get(yIndex);
        double difference = Math.abs(sum - target);
        if (difference < bestDifference) {
            bestPair = new Pair<>(X.get(xIndex), Y.get(yIndex));
            bestDifference = difference;
        }

        if (sum > target) {
            yIndex -= 1;
            if (yIndex < 0) {
                return bestPair;
            }
        } else if (sum < target) {
            xIndex += 1;
            if (xIndex == X.size()) {
                return bestPair;
            }
        } else {
            // Perfect match :)
            return bestPair;
        }
    }
}