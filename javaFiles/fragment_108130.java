List<Map<String, Object>> listResult = List.of(
        Map.of("key1", "c1", "key2", BigDecimal.valueOf(1)),
        Map.of("key1", "c2", "key2", BigDecimal.valueOf(1)),
        Map.of("key1", "c1", "key2", BigDecimal.valueOf(4))
);

Map<String, BigDecimal> topCount = listResult.stream().collect(Collectors.toMap(
        m -> (String) m.get("key1"),
        m -> (BigDecimal) m.get("key2"),
        BigDecimal::add
));
System.out.println(topCount);