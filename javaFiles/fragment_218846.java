public static int[][] zeroNegatives(int[][] arr)
{
    for (int r = 0; r < arr.length; r++) // Loop over array of arrays
    {
        for (int c = 0; c<arr[r].length; c++) // Loop over arrays
        {
            if (arr[r][c] < 0) // Check if negative
            {
                arr[r][c] *= -1; // "Change sign"
            }
        }
    }    
    return arr;
}