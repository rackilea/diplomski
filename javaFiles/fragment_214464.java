private static int findMaxOfLessThanFirst(int[] numList, int currentIndex, int len, int currentMax) {
    // when you reach the end of the array, return the currentMax
    if (currentIndex == len - 1) {
        return currentMax;
    }
    int firstElement = numList[0];
    // if the current element we are looking at in this stage of the recursion is greater
    // than the first element, ignore it and recurse on the next element
    if (numList[currentIndex] >= firstElement) {
        return findMaxOfLessThanFirst(numList, currentIndex + 1, len, currentMax);
    }
    int newMax;
    // if none of the previous conditions were true, and this current value is greater than
    // the currentMax, update the currentMax
    if (numList[currentIndex] > currentMax) {
        newMax = numList[currentIndex];
    }
    return findMaxOfLessThanFirst(numList, currentIndex + 1, len, newMax);
}