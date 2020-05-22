HashMap<String, int[]> map = new HashMap<>();

    map.put("Alex", new int[] {12,18});
    map.put("Bob", new int[] {13,45});
    map.put("Ball", new int[] {13,45});
    map.put("Candy", new int[] {1,2});

    Map<String, int[]> result = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue((int[] a, int[] b) ->
                    IntStream.of(b).sum() - IntStream.of(a).sum())
            )
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    System.out.println(result);