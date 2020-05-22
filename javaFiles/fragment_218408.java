RangeMap<Integer, String> rangeMap =
  ImmutableRangeMap.<Integer, String>builder()
    .put(Range.closed(90702, 90733), "AC")
    .put(Range.closed(10004, 10037), "AC")
    .put(Range.closed(10087, 10108), "EN")
    .put(Range.closed(10004, 10037), "AC")
    // ...
    .build();