public static void quickSort(int[] toSort, int l, int r){
    if(r - l <= 1)return;
    counter += r - l - 1;
    int p = choosePivot(l, r);
    int pivot = toSort[p];
    int oldP = toSort[p];
    toSort[p] = toSort[l];
    toSort[l] = oldP;

    int i = l + 1;
    for(int j = l + 1; j < r; j++){
        if(toSort[j] < pivot){
            int swap = toSort[j];
            toSort[j] = toSort[i];
            toSort[i] = swap;
            i++;
        }
    }


    oldP = toSort[i - 1];
    toSort[i - 1] = toSort[l];
    toSort[l] = oldP;

    quickSort(toSort, l, i-1);
    quickSort(toSort, i, r);
}

public static int choosePivot(int m, int n){
    return n - 1;
    //return m;
}