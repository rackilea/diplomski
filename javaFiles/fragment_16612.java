/** Returns the average of a collection of double */
private static Double average(Collection<Double> coll) {
  return coll.stream().collect(Collectors.averagingDouble(Double::doubleValue));
}

/** Returns the first, most distant element of a collection from a defined value. */
private static Double furthest(Collection<Double> coll, Double value) {
  return coll.stream()
    .max((d1, d2) -> Double.compare(Math.abs(d1-value), Math.abs(d2-value)))
    .orElse(null);
}