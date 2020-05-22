Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>() {{
        put(0, Arrays.asList(1, 2));
        put(1, Arrays.asList(2, 3));
        put(2, Arrays.asList(4));
        put(3, Arrays.asList(4, 5));
        put(4, Arrays.asList(5));
        put(5, Arrays.asList());
    }};
    System.out.println("Before " + map);
    Map<Integer, List<Integer>> sorted = map.entrySet().stream()
        .peek(e -> e.getValue().sort((a, b) -> map.get(b).size() - map.get(a).size()))      // sort values descending
        .sorted((a, b) -> b.getValue().size() - a.getValue().size())    // sort keys descending
        .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), (m0, m1) -> m0.putAll(m1));
    System.out.println("After  " + sorted);