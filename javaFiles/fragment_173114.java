public static void quickSort_R(int vals[], int l, int r) {
    if (l < r) {
        if((r-l) < 10) {
            bubbleSort(vals, r-l); //<--HERE
        }
        else {
            if ((r-1) == 1) { // two elements - trivial sort
                num_comps = num_comps + 1;
                if (vals[l] > vals[r])
                    swap(vals, l, r);
                return;
            }

            // partition the elements on the pivot s
            int s = partition(vals, l, r);

            //recurse on the two partitioned values
            quickSort_R(vals, l, s-1);
            quickSort_R(vals, s+1, r);
        }
    }
}