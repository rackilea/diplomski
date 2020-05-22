int findClosestBiggerInt(final int value, final int[] sortedArray) {
    final int index = Arrays.binarySearch(sortedArray, value + 1);
    if (index >= 0) {
        return sortedArray[index];
    } else {
        return sortedArray[-(index + 1)];
    }
}