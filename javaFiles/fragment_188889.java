public void recursiveQuickSort(int start, int end) {
    // if size 1 or less, don't need to do anything
    int pivotPosition = 0;
    if (start <=1 || end <= 1 ) {

    } else { // <<== Here
        pivotPosition =partition(start, end);
        recursiveQuickSort(start, pivotPosition-1);
        recursiveQuickSort(pivotPosition+1, end);
    }        // <<== Here
}