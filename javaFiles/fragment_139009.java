Map<Long,List<Item>> groupedItems =
    groups.stream()
          .flatMap(g -> items.stream()
                             .filter(i -> isGroupAccepting(i.getId(),g) || g == i.getGroup())
                             .map(i -> new SimpleEnty<>(g,i))
          .collect(Collectors.groupingBy(Map.Entry::getKey,
                   Collectors.mapping(Map.Entry::getValue,
                                      Collectors.toList())));