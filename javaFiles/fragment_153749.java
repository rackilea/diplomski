Map<String, List<String>> prefixGrouping = list1.stream()
    .collect(
        Collectors.groupingBy(
            item -> fooBarList.stream().filter(item::startsWith).findFirst().orElse("")
        )
    );