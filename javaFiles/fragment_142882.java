split = array.length%2;
System.err.printf(
    "%d broken into %d (%d to just before %d) and %d (%d to just before %d).\n",
    array.length, split, 0, split, array.length - split, split, array.length);
int[] array1 = mergeSort(subarray(array, 0, split));
int[] array2 = mergeSort(subarray(array, split, array.length));
return merge(array1, array2);