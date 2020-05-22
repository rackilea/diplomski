public static int numDuplicates (double[] list) {

    int dupCount = 0;
    for (int i = 0; i < list.length; i++) {
        for (int j = i + 1; j < list.length; j++, i++) { // HERE it is
            if (list[i] == list[j]) {
                dupCount++;
            }
        }
    }

    return dupCount;
}