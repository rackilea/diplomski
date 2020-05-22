private List<Person> findFilteredPersons(List<Person> persons, Predicate<Person> filter) {
    return collectSortedPersons(persons.stream().filter(filter));
}
private List<Person> findPersons(List<Person> persons) {
    return collectSortedPersons(persons.stream());
}
private List<Person> collectSortedPersons(Stream<Person> persons) {
    return persons
            .sorted(BY_NAME.thenComparing(BY_AGE))
            .collect(Collectors.toList());
}