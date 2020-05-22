public static void main(String[] args) {
    Map<String, String> m2 = new HashMap<>();
    m2.put("2018-02-01", "0");
    m2.put("2018-02-02", "0");
    m2.put("2018-02-03", "1");
    m2.put("2018-02-04", "2");
    m2.put("2018-02-05", "2");

    Map<String, List<String>> mapList = m2.entrySet().stream().collect(
            Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
    System.out.println(mapList);
}