PrimitiveIterator.OfInt it;
IntSummaryStatistics stats = pos.stream().map(ix -> x[ix]).summaryStatistics();
int min = stats.getMin(), max = stats.getMax();
if(max-min < stats.getCount()) {
    int[] counts = new int[max-min+1];
    pos.stream().forEach(ix -> counts[x[ix]-min]++);
    it = IntStream.rangeClosed(min, max)
                  .flatMap(val -> IntStream.range(0, counts[val-min]).map(ix -> val))
                  .iterator();
}
else {
    int[] tmp = pos.stream().map(p -> x[p]).toArray();
    Arrays.sort(tmp);
    it = Arrays.stream(tmp).iterator();
}
pos.stream().forEachOrdered(ix -> x[ix]=it.next());
assert !it.hasNext();