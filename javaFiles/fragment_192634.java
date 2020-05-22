static long[] normalize(Collection<OrderPosition> orderPositions) {
  return orderPositions.stream()
      .mapToLong(p -> p.getCodeType().getId())
      .sorted()
      .toArray();
}
...
return Arrays.equals(
  normalize(oldOrderPositions),
  normalize(newOrderPositions)
);