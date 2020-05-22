public static<T> void bubbleSort(T[] arr, Comparator<T> comparator) {

    if (arr == null || comparator == null) {
        throw new IllegalArgumentException("Comparator nor array can be null.");
    boolean swapped = true;

    while (swapped) {
        swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                T obj = arr[i];
                arr[i] = arr[i + 1]
                arr[i + 1] = obj;
                swapped = true;
            }
       }
   }


 }