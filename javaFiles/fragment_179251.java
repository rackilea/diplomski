public List<String> nameConcatenations() {
    JPAQuery q = new JPAQuery(entityManager);
    QPerson person = QPerson.person;
    StringExpression nameConcatenation = emptyIfNull(person.name1)
        .concat(emptyIfNull(person.name2));
    return q.from(person).list(nameConcatenation)
}

private static StringExpression emptyIfNull(StringExpression expression) {
    return expression.coalesce("").asString();
}