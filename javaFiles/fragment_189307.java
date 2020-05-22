//Diagonal to 1dArray and sorting

double [] [] bubbles()
{
    double [][] tempArray = new double [300][300];

    int y = 0;
    int z = 0;
    double median = 0;

    for (int i = 0; i < data.length; i++)
    {
        for (int j = 0; j < data[i].length; j++)
        {
            if ((i > 0) && (j > 0))
            {
                if ((i +1 < data[i].length) && (j +1 < data[j].length))
                {
                    double [] diagonals = getDiagonals(i, j);

                    //Need to sort here
                    median = diagonals[2];
                    tempArray[i][j] = median;
                }
            }
        }
    }
    return tempArray;
}