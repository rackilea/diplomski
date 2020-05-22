public static int getMaxValue(List<Integer> list) {
    IntSummaryStatistics stats = list.stream()
        .mapToInt(Integer::intValue)
        .summaryStatistics();
    return stats.getMax() - stats.getMin();
}