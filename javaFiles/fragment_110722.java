boolean isInArrayImproved(int[] array, int element) {
    if(Arrays.binarySearch(array, element) >= 0) {
        return true;
    }
    return false;
}