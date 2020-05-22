Map<List<String>, List<Booker>> result = list.stream()
    .collect(Collectors.groupingBy(
         dto -> Arrays.asList(dto.getStatus(), dto.getCategory(), dto.getType()),
         Collectors.mapping(
                 ProductDto::getBooker,
                 Collectors.toList())))));