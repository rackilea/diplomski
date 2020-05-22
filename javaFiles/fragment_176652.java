List<List<Integer>> list = Arrays.asList(1,2,2,3,4,4,4).stream()
    // grouping gets you a Map<Integer,List<Integer>>
    .collect(Collectors.groupingBy(s -> s)) 
    // take the values of this map and create of stream of these List<Integer>s
    .values().stream()   
    // collect them into a List
    .collect(Collectors.toList());