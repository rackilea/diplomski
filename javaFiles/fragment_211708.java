longListOfMemberMap.entrySet().stream()
   .flatMap(entry -> entry.getValue().stream().map(
       member -> 
           new AbstractMap.SimpleImmutableEntry<>(member, entry.getKey())))
   .collect(Collectors.groupingBy(
       Entry::getKey,
       Collectors.summingLong(Entry::getValue)));