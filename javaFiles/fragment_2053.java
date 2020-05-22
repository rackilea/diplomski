public Integer leader() {
    final Map<Integer, Integer> counts = new HashMap<>();
    final int neededLeaderCount = ((tos + 1) / 2) + 1;
    for (int i = 0; i <= tos; ++i) {
        int currentElementCount = counts.getOrDefault(stackArr[i], 0) + 1;
        if (currentElementCount >= neededLeaderCount) {
            return stackArr[i];
        }
        counts.put(stackArr[i], currentElementCount);
    }
    return null;
}