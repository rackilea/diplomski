public static void quickSort(int[] A,int l,int r) {
    if ((r-l)<2) return; //end recursion when there is just one or less elements to sort 

    int p = partition(A,l,r);

    if (l < p-1) { quickSort(A,l,p-1); }

    if (p < r) { quickSort(A,p,r); } 
}