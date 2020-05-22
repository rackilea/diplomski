SortedMap<BigDecimal, SortedMap<Optional<BigDecimal>, List<TestDto>>> test =  data
  .getTestDtos()
  .stream()
  .collect(
    Collectors.groupingBy(TestDto::getValue1, TreeMap::new,
      Collectors.groupingBy(dto -> Optional.ofNullable(dto.getValue2()),
        () -> new TreeMap<>((o1, o2) -> {
          if (o1.isPresent() && o2.isPresent()) {
            return o1.get().compareTo(o2.get());
          } else if (o1.isPresent()) {
            return -1;
          } else if (o2.isPresent()) {
            return 1;
          } else {
            return 0;
          }
        }),
        Collectors.toList())
    )
  );