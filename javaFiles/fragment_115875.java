/** modifies {@code persons} list. */
public static void filterPositions(
    List<Person> persons, Predicate<Person> predicate) {

    persons.removeIf(predicate.negate());
    if(persons.stream().mapToInt(Person::getSalary).sum() <= 5000)
        persons.clear();
}