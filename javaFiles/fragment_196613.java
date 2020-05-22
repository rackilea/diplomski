/**
65        * Sorts the specified array into ascending numerical order.
66        *
67        * <p>Implementation note: The sorting algorithm is a Dual-Pivot     Quicksort
68        * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This  algorithm
69        * offers O(n log(n)) performance on many data sets that cause other
70        * quicksorts to degrade to quadratic performance, and is typically
71        * faster than traditional (one-pivot) Quicksort implementations.
72        *
73        * @param a the array to be sorted
74        */
75       public static void sort(int[] a) {
76           DualPivotQuicksort.sort(a);
77       }