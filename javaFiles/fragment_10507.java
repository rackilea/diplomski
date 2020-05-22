private static <T> Collection<T> filterWhenMultipleOccurance(Collection<T> collection,
                                                             Function<T, ?> comparisonCriteria, 
                                                             int demandedOccuranceAmount) {
    return collection.stream()
                     .collect(groupingBy(comparisonCriteria))
                     .values()
                     .stream()
                     .filter(l -> l.size() >= demandedOccuranceAmount)
                     .flatMap(List::stream)
                     .collect(toList());
}