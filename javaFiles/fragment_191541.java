Map<String, Map<String, Map<String, List<Booker>>>> result = list.stream()
    .collect(Collectors.groupingBy(ProductDto::getStatus,
             Collectors.groupingBy(ProductDto::getCategory,
             Collectors.groupingBy(ProductDto::getType,
                 Collectors.mapping(
                         ProductDto::getBooker,
                         Collectors.toList())))));