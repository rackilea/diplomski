public static int numDuplicates (double[] list) {

    int dupCount = 0;
    for (int i = 1; i < list.length; i++) {
        if (list[i] == list[i - 1]) {
            dupCount++;
        }
    }
    return dupCount;
}