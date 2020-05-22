public static int countDifferences(int[] array1, int[] array2) {
    if (array1 == null || array2 == null || array1.length != array2.length) {
        return -1;
    }
    int differences = 0;

    for (int i=0; i < array1.length; i++) {
        if (array1[i] != array2[i]) {
            differences++;
        }
    }

    return differences;
}