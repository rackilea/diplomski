public static List<Map<String, Object>> innerJoin(List<Map<String, Object>> map1, List<Map<String, Object>> map2) {
    return map1.stream().flatMap(m1 -> 
        map2.stream()
                .filter(m2 -> m1.get("user").equals(m2.get("user")))
                .map((Map<String, Object> m2) -> {
                    Map<String, Object> mr = new HashMap<>();
                    mr.putAll(m1);
                    mr.putAll(m2);
                    return mr;
                })
    ).collect(Collectors.toList());
}