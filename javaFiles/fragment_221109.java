public static <T> void sort(List<T> collection, String field) throws NoSuchMethodException, NoSuchFieldException {
    if (collection == null || collection.isEmpty() || field == null || field.isEmpty()) {
        return;
    }

    // get a generic type of the collection
    Class<?> genericType = ActualGenericTypeExtractor.extractFromType(collection.getClass().getGenericSuperclass());

    // get a key-extractor function
    Function<T, Comparable<? super Object>> extractor = SortingKeyExtractor.extractFromClassByFieldName(genericType, field);

    // sort
    collection.sort(Comparator.comparing(extractor));
}