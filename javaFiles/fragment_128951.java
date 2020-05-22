static class Person {
    int age;
    // ... code ...
    public static Predicate<Person> ageFilter(final Range<Integer> range) {
        return new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return range.contains(person.age);
            }
        };
    }
}