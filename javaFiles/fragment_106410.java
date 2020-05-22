personList.stream()
          .collect(Collectors.groupingBy(Function.identity(),
                                         Collectors.mapping(Person::getId,
                                                            Collectors.toList())));
          .entrySet()
          .stream()
          .filter(e -> e.getValue().size() > 1)
          .forEach(e -> System.out.println(e.getKey().getId() + " " + e.getKey().getName() + " " + e.getKey().getFamilyName() + " " + e.getKey().getBirthday() + " " + e.getValue()));