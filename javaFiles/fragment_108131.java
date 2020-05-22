Map<String, BigDecimal> topCount = listResult.stream().collect(Collectors.toMap(
        m -> (String) m.get("key1"),
        m -> (BigDecimal) m.get("key2"),
        BigDecimal::add
)).entrySet().stream()
  .sorted(Comparator.<Entry<String, BigDecimal>, BigDecimal>comparing(Entry::getValue).reversed())
  .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                            (a,b) -> { throw new AssertionError(); },
                            LinkedHashMap::new));