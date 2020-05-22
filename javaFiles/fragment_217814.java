private String method(String input) {
    IntSummaryStatistics ss = input.chars().summaryStatistics();
    int min = ss.getMin();
    int[] counts = new int[ss.getMax()-min+1];
    input.chars().forEach(c -> counts[c-min]++);
    return IntStream.range(0, counts.length)
        .filter(ix -> counts[ix] > 0)
        .collect(StringBuilder::new,
                 (sb,c)->sb.append((char)(c+min)).append(counts[c]),
                 StringBuilder::append)
        .toString();
}