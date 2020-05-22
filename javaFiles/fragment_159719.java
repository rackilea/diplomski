public static void quickSort(int[] arr, int highE, int lowE)
{
    while (true)
    {
        if (lowE + 29 < highE)
        {
            ...
            quickSort(arr, storeE - 1, lowE);

            // not doing this any more
            //quickSort(arr, highE, storeE + 1);

            // instead, simply set the parameters to their new values
            // highE = highE;
            lowE = storeE + 1;
        }
        else
        {
            insertSort(arr, highE, lowE);
            return;
        }
    }
}