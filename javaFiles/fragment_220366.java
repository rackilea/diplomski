List<String> list1 = Arrays.asList("One", "Two", "Three");
List<String> list2 = Arrays.asList("Two", "Three", "Four");

Set<String> set = new HashSet<>(list2);

// Defined the Map here for formatting reasons.
Map<String, String> map;

map = list1.stream()
           .filter(set::contains)
           .collect(Collectors.toMap(k -> k, v -> list2.get(list2.indexOf(v))));

System.out.println(map);