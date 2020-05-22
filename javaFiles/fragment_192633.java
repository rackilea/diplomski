return Arrays.equals(
    oldOrderPositions.stream()
      .mapToLong(p -> p.getCodeType().getId())
      .sorted()
      .toArray(),
    newOrderPositions.stream()
      .mapToLong(p -> p.getCodeType().getId())
      .sorted()
      .toArray()
  );