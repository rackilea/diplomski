List<MyObj> filteredList = 
    map.entrySet()
       .stream()
       .filter(e->anotherSet.contains(e.getKey())) // you forgot contains
       .flatMap(e-> e.getValue().stream()) // flatMap requires a Function that 
                                           // produces a Stream
       .collect(Collectors.toList()); // you forgot ()