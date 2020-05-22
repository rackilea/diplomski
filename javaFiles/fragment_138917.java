Map<String, List<String>> map1 = new HashMap(){{
    put("file1", Arrays.asList("@tag1", "@tag2"));
    put("file2", Arrays.asList("@tag3", "@tag1"));
}};
Map<String, List<String>> map2 = map1.entrySet()
  .stream()
  .flatMap(entry -> entry.getValue()
                         .stream()
                         .map(tag -> new SimpleEntry<>(tag, entry.getKey())))
  .collect(Collectors.groupingBy(
                          SimpleEntry::getKey,
                          Collectors.mapping(SimpleEntry::getValue, Collectors.toList()))
  );
  System.out.println(Arrays.toString(map2.entrySet().toArray()));