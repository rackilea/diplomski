public static void quickSort(int[] arr, int highE, int lowE)
{
    while (lowE + 29 < highE)
    {
        ...
        quickSort(arr, storeE - 1, lowE);
        lowE = storeE + 1;
    }
    insertSort(arr, highE, lowE);
}