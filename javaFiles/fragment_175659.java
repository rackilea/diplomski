/**
 * @param input the list as your input
 * @param n number of occurrence (duplicates:2 , triplets:3 etc..)
 * @param <T> (type of elements)
 * @return elements with such conditional occurrent in a Set
 */
static <T> Set<T> findElementsWithNOccurrence(List<T> input, int n) {
    return input.stream()
            .filter(a -> Collections.frequency(input, a) == n) // filter by number of occurrences
            .collect(Collectors.toSet()); // collecting to a final set (one representation of each)
}