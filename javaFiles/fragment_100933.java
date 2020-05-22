list.stream()
    .skip(1)
    .map(Person::getAge)
    .map(age -> age - list.get(0).getAge())
    .map(Math::abs)
    .forEach(System.out::println);