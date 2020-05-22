public static int findVals(int[] arr, int numToFind) {
    int occurence = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == numToFind)
            occurence++;
    }
    return occurence;
}