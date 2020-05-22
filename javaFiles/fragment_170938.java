MyObj[] filteredArray = 
    map.entrySet()
       .stream()
       .filter(e->anotherSet.contains(e.getKey()))
       .flatMap(e-> e.getValue().stream())
       .toArray(MyObj[]::new);