public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
    int lastSwap = a.length - 1, i;
    for (i = lastSwap; i > 0;) {
        for (int j = 0; j < i; ++j) {
            numComp++;
            if (a[j].compareTo(a[j + 1]) > 0) {
                numAsgn += 3;
                T temp = a[j + 1];
                a[j + 1] = a[j];
                a[j] = temp;
                lastSwap = j;
            }
        }
        if(i == lastSwap) {
            //sorted
            break;
        }
        i = lastSwap;
        if (tracing) {
            System.out.println("one more bubbled up: "
                    + Arrays.toString(a));
        }
    }
}