private static String[] mergeArrays(String[] arr1, String[] arr2, int firstArray, int secondArray) {
    final String[] ret = new String[arr1.length + arr2.length];

    for (int j = 0, k = 0; j < arr1.length || k < arr2.length;) {
        while (j < arr1.length) {
            ret[j + k] = arr1[j];
            if (++j % firstArray == 0)
                break;
        }
        while (k < arr2.length) {
            ret[j + k] = arr2[k];
            if (++k % secondArray == 0)
                break;
        }
    }

    return ret;
}