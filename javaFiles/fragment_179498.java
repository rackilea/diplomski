List<AnotherObject> result = items.stream()
     .collect(Collectors.groupingBy(Item::getKey, LinkedHashMap::new, Collectors.toList()))
     .entrySet()
     .stream()
     .map(e -> new AnotherObject(e.getKey(), e.getValue()))
     .collect(Collectors.toList());