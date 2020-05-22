Set<Integer> ids =
    list1.stream()
         .filter(e -> !mapDate.containsKey(e.getId()) || 
                      e.getDate().isAfter(mapDate.get(e.getId())) ||
                      mapCount1.get(e.getId()) > mapCount2.get(e.getId()))
         .map(Entry::getId)
         .collect(toSet());