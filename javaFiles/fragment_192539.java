/**
 * Whether array has at least one element x such that l <= x < u.
 */
boolean withinRangeSorted (int[] array, int l, int u) {
    int start = 0;
    int end = array.length;
    while (start < end) {
        int current = (start + end) / 2;
        if (array[current] >= u) {
            end = current;
        } else if (array[current] < l) {
            start = current + 1;
        } else {
            return true;
        }
    }
    return false;
}