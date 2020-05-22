List<Person> persons = Arrays.asList(
        new Person("p1", 2, true),
        new Person("p2", 0, false),
        new Person("p3", 0, true),
        new Person("p4", 1, false),
        new Person("p5", 3, true));

persons.stream().sorted(Comparator
            .comparing(Person::isFavorite).reversed()
            .thenComparing(p -> p.getCount() == 0))
    .forEach(System.out::println);