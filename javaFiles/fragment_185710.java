public static <T> boolean matchingSome(
        T elem, 
        List<Predicate<T>> predicates, 
        double threshold) {

    long predsToMatch = (long) ((double) predicates.size() * threshold);

    long predsMatched = predicates.stream()
        .filter(p -> p.test(elem))
        .limit(predsToMatch) // this limit is to short-circuit as soon as
        .count();            // predsToMatch predicates evaluate to true

    return predsMatched == predsToMatch;
}