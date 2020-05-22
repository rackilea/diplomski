Map<String, List<String>> map = 
    mySet.stream()
         .collect(Collectors.toMap(Function.identity(),
                                   string -> {
                                       // put logic that returns List<String> here
                                   }));