// Java:
Map<Person.Sex, List<String>> namesByGender =
      roster.stream().collect(
        Collectors.groupingBy(
            Person::getGender,                      
            Collectors.mapping(
                Person::getName,
                Collectors.toList())));