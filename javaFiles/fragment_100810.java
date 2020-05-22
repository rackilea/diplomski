public boolean hasNamedQuery(Class<?> clazz, String nameOfQuery) {
    boolean foundQueryByName = false;
    NamedQueries namedQueries = clazz.getAnnotation(NamedQueries.class);
    if (namedQueries != null && namedQueries.value() != null) {
        NamedQuery[] values = namedQueries.value();
        for (int i = 0; i < values.length && !foundQueryByName; i++) {
            foundQueryByName |= (nameOfQuery.equals(values[i].name()));
        }
    }
    return foundQueryByName;
}