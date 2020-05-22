Map<T, Map<V, List<SubItem>>> result = pojo.getItems().stream()
    .flatMap(item -> item.subItems.stream()
        .map(sub -> new AbstractMap.SimpleImmutableEntry<>(item, sub)))
    .collect(Collectors.groupingBy(e -> e.getKey().getKey1(),
                Collectors.mapping(Map.Entry::getValue,
                    Collectors.groupingBy(SubItem::getKey2))));