private void doMergeSort(int 0, int 3) {

  if (0 < 3) // condition is met {
    int middle = 0 + (3 - 0) / 2;
    // middle value is set to 1
    doMergeSort(lowerIndex, middle);
    // Below step sorts the right side of the array
    doMergeSort(middle + 1, higherIndex);
    // Now merge both sides
    mergeParts(lowerIndex, middle, higherIndex);
   }
}