// gets two sorted arrays and returns the merged sorted array of both
static int[] merge(int[] firstSortedArray, int[] secondSortedArray) {
    int[] result = int[firstSortedArray.length + secondSortedArray.length];
    // merge both arrays into result
    return result;
}

// gets an input array and returns the same array in a sorted fashion
static int[] split(int[] inputArray) {
    // an array of size zero/one is already sorted and can be return unchanged
    if(inputArray.length == 0 || inputArray.length == 1)
        return inputArray; 

    int[] leftSortedHalf = split(/*copy first half here*/);
    int[] rightSortedHalf = split(/*copy second half here*/);
    return merge(leftSortedHalf, rightSortedHalf);
}