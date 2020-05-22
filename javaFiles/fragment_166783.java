void QuickSort(int a[], int lo, int hi)
{
    if (lo >= hi)
        return;
    int p = a[(lo + hi) / 2];   // set pivot, could use median of 3 here
    int i = lo-1;
    int j = hi+1;
    while (true)
    {
        while (a[++i] < p) ;    // increase i until a[i] >= pivot
        while (a[--j] > p) ;    // decrease j until a[j] <= pivot
        if (i >= j)             // break if indices meet or cross
            break;
        swap(a[i], a[j]);
    }
    QuickSort(a, lo, j);        // this part includes values <= pivot
    QuickSort(a, j + 1, hi);    // this part includes values  > pivot
}

Hoare type quicksort, p is pivot

          p              quicksort(a, 0, 7)
07 04 05 03 06 00 01 02
02                   07  swap
   01             04     swap
      00       05        swap
    p                    quicksort(a, 0, 3)
02 01 00 03
00    02                 swap
 p                       quicksort(a, 0, 1)
00 01   
       p                 quicksort(a, 2, 3)
      02 03
                p        quicksort(a, 4, 7)
            06 05 04 07
            04    06     swap
             p           quicksort(a, 4, 5)
            04 05
                   p     quicksort(a, 6, 7)
                  06 07