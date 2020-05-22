ImmutableMap<String, Long> oldPrices = ImmutableMap.of("banana", 4, "apple", 7);
ImmutableMap<String, Long> newPrices =
    new ImmutableMap.Builder()
    .putAll(oldPrices)
    .put("orange", 9)
    .build();