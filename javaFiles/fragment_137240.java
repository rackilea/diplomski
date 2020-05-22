Map<String, Collection<String>> map = new LinkedHashMap<>(); // to preserve the order
map.put("A", Arrays.asList("a1", "a2", "a3", "a4"));
map.put("B", Arrays.asList("b1", "b2", "b3"));
map.put("C", Arrays.asList("c1", "c2"));

ofCombinations(map.values(), LinkedHashSet::new).forEach(System.out::println);