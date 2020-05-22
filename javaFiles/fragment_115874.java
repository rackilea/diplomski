public static List<Person> filterPositions(
    List<Person> persons, Predicate<Person> predicate) {

    persons = persons.stream().filter(predicate).collect(Collectors.toList());
    return persons.stream().mapToInt(Person::getSalary).sum() > 5000?
        persons: Collections.emptyList();
}