long result = myList.stream()
         .collect(Collectors.groupingBy(
                   Function.identity(),
                  Collectors.counting()))
         .entrySet()
         .stream()
         .filter(entry -> entry.getValue() == 1)
         .map(Entry::getKey)
         .count();