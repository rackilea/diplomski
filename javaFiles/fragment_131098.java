Collection<SortedSet<Long>> sets = //...

long minAfter50 = Long.MAX_VALUE;
for (SortedSet<Long> set : sets) {
    final Long first = set.tailSet(51L).first();
    minAfter50 = Math.min(minAfter50, first);
}