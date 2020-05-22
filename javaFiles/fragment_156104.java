} else {
    System.out.println("Left Index is originally: " + leftIndex);
    int[] left = Arrays.copyOfRange(theArray, 0, mid);
    int[] right = Arrays.copyOfRange(theArray, mid, theArray.length);
    //sort the lower half
    mergeSortHelper(left, leftIndex);
    mergeSortHelper(right, leftIndex + left.length);
    //merge them together
    merge(left, right, leftIndex);
    System.out.println("Left Index is now: " + leftIndex);
    System.out.println("Right Index is now: " + (leftIndex + mid));
    System.out.println(Arrays.toString(numBars));
    left = Arrays.copyOfRange(numBars, leftIndex, leftIndex + mid);
    right = Arrays.copyOfRange(numBars, leftIndex + mid, leftIndex + mid + right.length);
}