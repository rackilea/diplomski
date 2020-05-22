/**
 * @param input the list as your input
 * @param n     number of occurrence (duplicates :2 , triplets :3 etc)
 * @param <T>   (type of elements)
 * @return elements in a set
 */
static <T> Set<T> findElementsWithNOccurrence(List<T> input, int n) {
    return input.stream() // Stream<T>
            .collect(Collectors.groupingBy(Function.identity(), 
                    Collectors.counting())) // Map<T, Long>
            .entrySet() // Set<Map.Entry<T,Long>>
            .stream() // Stream<Map.Entry<T,Long>>
            .filter(e -> e.getValue() == n) // filtered with frequency 'n'
            .map(Map.Entry::getKey) // Stream<T>
            .collect(Collectors.toSet()); // collect to Set
}