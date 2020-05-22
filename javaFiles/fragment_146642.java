Map<String, A> result =
    listOfA.stream()
           .collect(Collectors.groupingBy(a -> a.type)) // Map<String,List<A>>
           .entrySet()
           .stream()
           .collectors.toMap(e -> e.getKey (),
                             e -> new A (e.getKey(),
                                         e.getValue()
                                          .stream()
                                          .flatMap(a->a.names.stream()) 
                                          .collect(Collectors.toList())));