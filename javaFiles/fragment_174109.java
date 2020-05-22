ImmutableMap<String, Long> oldPrices = ImmutableMap.of("banana", 4, "apple", 7);
ImmutableMap<String, Long> newPrices =
    new ImmutableMap.Builder()
    .putAll(new HashMap<>() {{
        putAll(oldPrices);
        put("orange", 9); // new value
        put("apple", 12); // override an old value
     }})
    .build();