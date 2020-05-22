public static int arrayValuesSum(int[] array) {
    return arrayValuesSumRecursive(array, 0, array.length);
}

public static int arrayValuesSumRecursive(int[] array, int start, int length) {

    if (length == 0)
        return 0;

    if (length == 1)
        return array[start];

    int half = length / 2;

    return arrayValuesSumRecursive(array, start, half) + arrayValuesSumRecursive(array, start + half, length - half);
}