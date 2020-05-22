Map<Item, List<Owner>> map = owners.stream()
    .flatMap(owner -> owner.getItems()
                    .stream()
                    .map(item -> new AbstractMap.SimpleEntry<>(item, owner)))
    .collect(Collectors.groupingBy(Entry::getKey, 
                   Collectors.mapping(Entry::getValue, 
                                     Collectors.toList())));