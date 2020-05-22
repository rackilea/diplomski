List<Person> persons = new ArrayList<>();

/* Java 8+ using streams and predicate (lambda expression)*/
List<Person> personsOlderThan10 = persons.stream().filter(p -> p.age > 10).collect(Collectors.toList());

/* Java 7- using Predicates*/
List<Person> personNamedJohn = new ArrayList<>(persons);
personNamedJohn.removeIf(new Predicate<Person>() {

    @Override
    public boolean test(final Person person) {
        if (person.getFirstName().toLowerCase().equals("john")) {
            return false;
        }
        return true;
    }
});