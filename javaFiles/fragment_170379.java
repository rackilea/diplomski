Map<String, String> myMap = new HashMap<>();
myMap.put("A", "fortran");
myMap.put("B", "java");
myMap.put("C", "c++");
myMap.put("D", "php");

List<String> keysForFiltering = Arrays.asList("A", "C");

Predicate<Entry<String, String>> myPredicate = t -> keysForFiltering.contains(t.getKey());

Map<String, String> filteredMap = myMap
        .entrySet().stream().filter(myPredicate)
        .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

System.out.println(filteredMap);