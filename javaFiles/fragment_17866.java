data.stream()
    .flatMap(student -> student.getHobbies().stream().map(hobby -> new SimpleEntry<>(hobby, student)))
    .collect(Collectors.groupingBy(
            Entry::getKey,
            Collectors.mapping(Entry::getValue, Collectors.toList())
));