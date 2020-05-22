/**
 * Simple class to hold the start and end of a range.
 */
public static class Range implements Comparable<Range> {
    int start;
    int end;
    public int compareTo(Range other) {
        if (start < other.start) return -1;
        if (start > other.start) return 1;
        if (end < other.end) return -1;
        if (end > other.end) return 1;
        return 0;
    }
}
/**
 * Remove a list of ranges from an array.
 * @param original the array from which to remove the values.
 * @param toRemove the list of ranges to remove. This must be
 *    sorted in ascending order of range start before calling this method.
 * @param compact flag indicating whether to simply compact the original
 *    array or to copy the values into a new array. If false, will allocate
 *    a new array of the exact size needed to contain the elements not removed.
 */
public int[] remove(int[] original, List<Range> toRemove, boolean compact) {
    int[] a;
    if (compact) {
        a = original;
    } else {
        int len = 0;
        for (Range range : toRemove) len += range.end - range.start;
        a = new int[original.length - len];
    }
    int nextSource = 0;
    int nextDest = 0;
    for (Range range : toRemove) {
        if (nextSource < range.start) {
            System.arraycopy(original, nextSource, a, nextDest,
                range.start - nextSource);
            nextDest += range.start - nextSource;
            nextSource = range.start;
        }
        nextSource = range.end;
    }
    if (nextSource < original.length) {
        System.arraycopy(original, nextSource, a, nextDest,
            original.length - nextSource);
    }
    return a;
}