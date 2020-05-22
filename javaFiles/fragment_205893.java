final Map<Integer, String> map = ImmutableMap.of(
    1, "aa",
    2, "bb",
    3, "cc");
final Map<Integer, String> filteredMap = Maps.filterEntries(map,
    e -> e.getKey() >= 1 && !"cc".equals(e.getValue()));