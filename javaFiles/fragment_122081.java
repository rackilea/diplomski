private static void mergeSort(Object[] src,
              Object[] dest,
              int low, int high, int off,
              Comparator c) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length < INSERTIONSORT_THRESHOLD) {
            for (int i=low; i<high; i++)
                // here the Comparator's compare method is called
                for (int j=i; j>low && c.compare(dest[j-1], dest[j])>0; j--) 
        ...
    }