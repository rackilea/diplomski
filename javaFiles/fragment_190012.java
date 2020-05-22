IntSummaryStatistics stats = pos.stream().map(ix -> x[ix]).summaryStatistics();
int min = stats.getMin(), max = stats.getMax();
int[] counts = new int[max-min+1];
pos.stream().forEach(ix -> counts[x[ix]-min]++);
PrimitiveIterator.OfInt it
  = IntStream.rangeClosed(min, max)
             .flatMap(val -> IntStream.range(0, counts[val-min]).map(ix -> val))
             .iterator();
pos.stream().forEachOrdered(ix -> x[ix]=it.next());
assert !it.hasNext();