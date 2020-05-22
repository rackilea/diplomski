public static <T> T[][] mergeArrays(Class<T> clazz, T[][]... arrays) {
    // determine length of 1st dimension.
    int dim1 = 0;
    for (T[][] arr : arrays) {
        dim1 += arr.length;
    }
    // Create new 2Dim Array
    T[][] result = (T[][]) Array.newInstance(clazz, dim1, 0);
    // Fill the new array with all 'old' arrays
    int index = 0;
    for (T[][] arr : arrays) {
        for (T[] array : arr) {
            // changes within your old arrays will reflect to merged one
            result[index++] = array;
        }
    }
    return result;
}