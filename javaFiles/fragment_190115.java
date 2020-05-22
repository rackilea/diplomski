public static Set<Person> prefixName(final Set<Person> persons, final String prefix) {
    final Set<Person> personsWithPrefix = new HashSet<>();
    for (final Person person : persons) {
        if (person.getName().startsWith(prefix)) {
            personsWithPrefix.add(person);
        }
    }
    return personsWithPrefix;
}