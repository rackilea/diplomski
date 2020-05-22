public static void selectionSort (double...arr)
{
    int i = 0, j = 0, smallest = 0;
    double temp = 0.0;

    for (i = 0; i < arr.length - 1; i++)
    {
        smallest = i;
        for (j = 1; j < arr.length - 1; j++)
        {
            if (arr[j] < arr[smallest])
                smallest = j;
        }
        temp = arr[smallest];
        arr[smallest] = arr[i];
        arr[i] = temp;
    }
}