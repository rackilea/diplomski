return items.stream()
        .flatMap(p -> p.getBelongsToCategories()
                .stream()
                .map(l -> new AbstractMap.SimpleEntry<>(l, p)))
        .collect(Collectors.groupingBy(Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue,
                        Collectors.toList())));