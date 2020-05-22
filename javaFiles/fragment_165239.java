/**
 * Calculates all subsets of a that have a sum <= capacity
 * and to which one cannot add another element from a without exceeding the capacity.
 * @param a elements to put in sets;
 * even when two elements from a are equal, they are considered distinct
 * @param capacity maximum sum of a returned subset
 * @return collection of subsets of a.
 * Each subset is represented by a boolean array the same length as a
 * where true means that the element in the same index in a is included,
 * false that it is not included.
 */
private static Collection<boolean[]> maximalSubsetsWithinCapacity(int[] a, int capacity) {
    List<boolean[]> b = new ArrayList<>();
    addSubsets(a, capacity, new boolean[0], 0, Integer.MAX_VALUE, b);
    return b;
}

/** add to b all allowed subsets where the the membership for the first members of a is determined by paritalSubset
 * and where remaining capacity is smaller than smallestMemberLeftOut
 */
private static void addSubsets(int[] a, int capacity, boolean[] partialSubset, int sum,
        int smallestMemberLeftOut, List<boolean[]> b) {
    assert sum == IntStream.range(0, partialSubset.length)
            .filter(ix -> partialSubset[ix])
            .map(ix -> a[ix])
            .sum() 
            : Arrays.toString(a) + ' ' + Arrays.toString(partialSubset) + ' ' + sum;
    int remainingCapacity = capacity - sum;
    if (partialSubset.length == a.length) { // done
        // check capacity constraint: if there’s still room for a member of size smallestMemberLeftOut,
        // we have violated the maximality constraint
        if (remainingCapacity < smallestMemberLeftOut) { // OK, no more members could have been added
            b.add(partialSubset);
        }
    } else {
        // try next element from a.
        int nextElement = a[partialSubset.length];
        // i.e., decide whether  should be included.
        // try with and without.

        // is including nextElement a possibility?
        if (nextElement <= remainingCapacity) { // yes
            boolean[] newPartialSubset = Arrays.copyOf(partialSubset, partialSubset.length + 1);
            newPartialSubset[partialSubset.length] = true; // include member
            addSubsets(a, capacity, newPartialSubset, sum + nextElement, smallestMemberLeftOut, b);
        }

        // try leaving nextElement out
        boolean[] newPartialSubset = Arrays.copyOf(partialSubset, partialSubset.length + 1);
        newPartialSubset[partialSubset.length] = false; // exclude member
        int newSmallestMemberLeftOut = smallestMemberLeftOut;
        if (nextElement < smallestMemberLeftOut) {
            newSmallestMemberLeftOut = nextElement;
        }
        addSubsets(a, capacity, newPartialSubset, sum, newSmallestMemberLeftOut, b);
    }