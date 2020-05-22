public static int[] findMaximumIndex(int[ ][ ] a)
{
    int maxVal = -99999
    int[] answerArray = new int[2];
    for(int row = 0; row < a.length; row++)
    {
        for(int col = 0; col < a[row].length; col++)
        {
            if(a[row][col] > maxVal)
            {
                maxVal = a[row][col];
                answerArray[0] = row;
                answerArray[1] = col;
            }
        }
    }
    return answerArray;
}