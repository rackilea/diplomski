List<List<Object>> grouped = 
    myList.stream()
          .collect(collectingAndThen(
                       groupingBy(Object::getClass, LinkedHashMap::new, toList()), 
                       map -> new ArrayList<>(map.values)
          ));