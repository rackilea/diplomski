List<List<Integer>> integerList = 
    doubleList.stream()
              .map(l -> l.stream()
                         .map(Double::intValue)
                         .collect(Collectors.toList()))
              .collect(Collectors.toList());