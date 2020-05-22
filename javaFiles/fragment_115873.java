public static List<Person> filterPositions(
    List<Person> persons, Predicate<Person> predicate) {

    return persons.stream().filter(predicate).mapToInt(Person::getSalary).sum() > 5000?
        persons.stream().filter(predicate).collect(Collectors.toList()):
        Collections.emptyList();
}