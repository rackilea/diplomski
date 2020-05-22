public static void main(String[] args) {
    Map<LocalDate, Map<Integer, List<String>>> mainMap = new HashMap<>();

    Map<Integer, List<String>> map = new HashMap<>();
    map.put(120, Arrays.asList("1", "2", "3"));
    map.put(121, Arrays.asList("1", "2", "3"));
    map.put(122, Arrays.asList("1", "2", "3"));
    map.put(123, Arrays.asList("1", "2", "3"));
    mainMap.put(LocalDate.of(2016, 2, 23), map);

    Map<LocalDate, List<String>> childMap = new HashMap<>();
    childMap.put(LocalDate.of(2016, 2, 23), Arrays.asList("120", "123"));

    mainMap.forEach((k, v) -> 
        v.keySet().removeIf(s -> 
            Optional.ofNullable(childMap.get(k)).map(o -> o.contains(s.toString())).orElse(false)
        )
    );

    System.out.println(mainMap);
}