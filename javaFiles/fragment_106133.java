public static int[] swapArray(int[] array) {
    array[0] += array[array.length-1];
    array[array.length-1] = array[0] - array[array.length-1];
    array[0] -= array[array.length-1];
    return array;
}