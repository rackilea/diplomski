/**
 * Search for {@code value1} and {@code value2} in {@code array} array.
 * 
 * @param array given array to be searched.
 * @param value1 value to be searched.
 * @param value2 value to be searched.
 * @return true if found both values in the given array.
 */
private static boolean hasBothValues(int[] array, int value1, int value2) {
    int totalMatches = 0;
    for (int value : array) {
        if (value == value1 || value == value2)
            totalMatches++;
        if (totalMatches >= 2)
            return true;
    }
    return false;
}