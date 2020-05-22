public static int sumOfElementsInLastColumn(int[][] arr)
{
    int sum = 0;

    for (int i = 0; i < arr.length; i++)
    {
        int [] row = arr[i];

        sum += row[row.length - 1];
    }
    return sum;
}