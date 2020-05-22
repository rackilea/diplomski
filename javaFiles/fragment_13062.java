Map<String, List<Integer>> map = new HashMap<>();

List<Integer> list1 = map.getOrDefault("foo", Collections.emptyList());
System.out.println(list1); // empty list
System.out.println(map);   // map is still empty

List<Integer> list2 = map.computeIfAbsent("bar", s -> new ArrayList<Integer>());
System.out.println(list2); // empty list
System.out.println(map);   // entry added to map