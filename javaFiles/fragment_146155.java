Map<String, Set<String>> map = new LinkedHashMap<>();
map.put("A", new LinkedHashSet<>(Arrays.asList("1", "2", "3")));
map.put("B", new LinkedHashSet<>(Arrays.asList("4", "5")));
map.put("C", new LinkedHashSet<>(Arrays.asList("6")));

List<String> result = null;
for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
    String key = (result == null ? "" : "&") + entry.getKey() + "=";
    Set<String> values = entry.getValue();
    if (values.isEmpty())
        throw new IllegalArgumentException("Empty set not supported");
    List<String> crossJoin = new ArrayList<>((result == null ? 1 : result.size()) * values.size());
    if (result == null)
        for (String value : values)
            crossJoin.add(key + value);
    else
        for (String left : result)
            for (String value : values)
                crossJoin.add(left + key + value);
    result = crossJoin;
}
if (result == null)
    throw new IllegalArgumentException("Empty map not supported");
for (String value : result)
    System.out.println(value);