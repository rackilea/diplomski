public static int checkSubsets(String[][] subsets) {

    // The results.
    final Set<Integer> duplicateRows = new HashSet<>();

    // From the first occurrence of a duplicate value we do not know it yet,
    // so need to remember.
    final Map<String, Integer> firstRowOfValue = new HashMap<>();

    for (int i = 0; i < subsets.length; ++i) {
        for (int j = 0; j < subsets[i].length; ++j) {
            final String value = subsets[i][j];
            Integer oldRow = firstRowOfValue.putIfAbsent(value, i);
            if (oldRow != null) { // Duplicates
                duplicateRows.add(i);
                duplicateRows.add(oldRow);
                // oldRow might already be added if third duplicate or same row.
            }
        }
    }

    IntStream.rangeOf(0, subsets.length)
        .filter(i -> !duplicateRows.contains(i))
        .forEach(System.out::println);
    return subsets.length - duplicateRows.size();
}