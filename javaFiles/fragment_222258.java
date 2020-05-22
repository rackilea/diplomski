/**
 * Returns a list of all possible combinations of the entered array of lists.
 *
 * Example: [["A", "B"], ["0", "1", "2"]]
 * Returns: [["A", "0"], ["A", "1"], ["A", "2"], ["B", "0"], ["B", "1"], ["B", "2"]]
 *
 * @param <T> The type parameter
 * @param elements An array of lists
 * @return All possible combinations of the entered lists
 */
public static <T> List<List<T>> createCombinations(List<T>... elements) {
    List<List<T>> returnLists = new ArrayList<>();

    int[] indices = new int[elements.length];
    for (int i = 0; i < indices.length; i++) {
        indices[i] = 0;
    }

    returnLists.add(generateCombination(indices, elements));
    while (returnLists.size() < countCombinations(elements)) {
        gotoNextIndex(indices, elements);
        returnLists.add(generateCombination(indices, elements));
    }

    return returnLists;
}

/**
 * Jumps to the next index for creating combinations.
 *
 * This method updates the indices.
 *
 * @param <T> The type parameter
 * @param indices The index positions
 * @param elements Array of lists
 */
private static <T> void gotoNextIndex(int[] indices, List<T>... elements) {
    for (int j = indices.length - 1; j >= 0; j--) {
        if (indices[j] == elements[j].size() - 1) {
            indices[j] = 0;
            continue;
        }
        indices[j]++;
        return;
    }
}

/**
 * Return a combination in the form of a list based on the current indices.
 *
 * @param <T> The type parameter
 * @param indices The index positions
 * @param elements Array of lists
 * @return The combination
 */
private static <T> List<T> generateCombination(int[] indices, List<T>... elements) {
    List<T> returnList = new ArrayList<>();
    for (int i = 0; i < indices.length; i++) {
        returnList.add(elements[i].get(indices[i]));
    }
    return returnList;
}

/**
 * Counts the possible number of combinations in this array of lists.
 *
 * @param <T> The type parameter
 * @param elements Array of lists
 * @return Possible number of combinations
 */
private static <T> int countCombinations(List<T>... elements) {
    int count = 1;
    for (List<T> list : elements) {
        count *= list.size();
    }
    return count;
}

/**
 * Returns a list of all possible combinations of the entered list of lists.
 *
 * Example: [["A", "B"], ["0", "1", "2"]]
 * Returns: [["A", "0"], ["A", "1"], ["A", "2"], ["B", "0"], ["B", "1"], ["B", "2"]]
 *
 * @param <T> The type parameter
 * @param elements A list of lists
 * @return All possible combinations of the entered lists
 */
public static <T> List<List<T>> createCombinations(List<List<T>> elements) {
    return createCombinations((List<T>[])elements.toArray());
}