long minAfter50 = Long.MAX_VALUE;
for (TreeSet<Long> set : sets) {
    final Long higher = set.higher(50L);
    if (higher != null && higher < minAfter50) {
        minAfter50 = higher;
    }
}