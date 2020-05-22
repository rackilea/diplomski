private void merge(int low, int middle, int high) {

    int i = low, j = middle+1;
    int index = low;

    for (int k = 0; k <= high; k++) {
        tempArray[k] = nums[k];
    }

    /*
      Copy the smallest values from either the left
      or the right side back to the original array
     */
    while ((i <= middle) && (j <= high)) {
        if (tempArray[i] <= tempArray[j]) {
            nums[index++] = tempArray[i++];
        } else {
            nums[index++] = tempArray[j++];
        }
    }

    // fill the left side of the array
    while (i <= middle) {
        nums[index++] = tempArray[i++];
    }

    // fill the right side of the array
    while (j <= high) {
        nums[index++] = tempArray[j++];
    }
}