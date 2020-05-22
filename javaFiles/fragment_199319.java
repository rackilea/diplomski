public static <T extends Comparable<T>> void mergeSort(T[] data) {
        long startTime = System.nanoTime();// stores
                            // beginning
                            // of
                            // merge
                            // sort
        mergeSort(data, 0, data.length - 1);
        long endTime = System.nanoTime();// stores
                            // end
                            // of
                            // merge
                            // sort
        /* Wrong variable */
        selectionSortExecutionTime = endTime - startTime;// computes
                                // total
                                // execution
                                // time
                                // of
                                // merge
                                // sort
}