if (!persons.isEmpty()) {
    // get the first (only?) person type
    TypePerson possiblyOnlyType = resolvePersonType(persons.get(0).age);
    // if all items in list have same value...
    if (persons.stream()
            .allMatch(person -> resolvePersonType(person.age) == possiblyOnlyType)) {
        return possiblyOnlyType;
    }
}
return null;