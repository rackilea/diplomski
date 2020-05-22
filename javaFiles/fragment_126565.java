private static void bubbleSortByOccurrences(int[] arr) {
    int[][] counter = new int[2][arr.length];
    int counterIndex = -1;

    for (int value : arr) {
        int idx = 0;
        for (; idx <= counterIndex; idx++) {
            if (counter[0][idx] == value) {
                counter[1][idx]++;

                while (idx > 0 && counter[1][idx] > counter[1][idx-1]) {
                    int temp = counter[1][idx];
                    counter[0][idx] = counter[0][idx-1];
                    counter[1][idx] = counter[1][idx-1];
                    counter[0][idx-1] = value;
                    counter[1][idx-1] = temp;
                    idx--;
                }
                break;
            }
        }

        if (idx > counterIndex) {
            counter[0][idx] = value;
            counter[1][idx]++;
            counterIndex = idx;
        }
    }

    fillArrayBackwards(arr, counter, counterIndex);
}

private static void fillArrayBackwards(int[] buf, int[][] counter, int counterIndex) {
    for (int i = counterIndex, j = buf.length - 1; i >=0; i--) {
        for (int k = 0; k < counter[1][i]; k++) {
            buf[j--] = counter[0][i];
        }
    }
}